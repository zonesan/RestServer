package com.asiainfo.ocmanager.rest.resource.executor;

import org.apache.log4j.Logger;

import com.asiainfo.ocmanager.rest.bean.ResourceResponseBean;
import com.asiainfo.ocmanager.rest.constant.Constant;
import com.asiainfo.ocmanager.rest.resource.persistence.UserPersistenceWrapper;
import com.asiainfo.ocmanager.rest.resource.utils.TenantUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class TenantResourceUnAssignRoleExecutor implements Runnable {

	private static Logger logger = Logger.getLogger(TenantResourceUnAssignRoleExecutor.class);

	private String tenantId;
	private int instnaceNum;
	private JsonArray allServiceInstancesArray;
	private String userId;

	public TenantResourceUnAssignRoleExecutor(String tenantId, JsonArray allServiceInstancesArray, String userId,
			int instnaceNum) {
		this.tenantId = tenantId;
		this.instnaceNum = instnaceNum;
		this.allServiceInstancesArray = allServiceInstancesArray;
		this.userId = userId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public int getInstnaceNum() {
		return instnaceNum;
	}

	public void setInstnaceNum(int instnaceNum) {
		this.instnaceNum = instnaceNum;
	}

	public JsonArray getAllServiceInstancesArray() {
		return allServiceInstancesArray;
	}

	public void setAllServiceInstancesArray(JsonArray allServiceInstancesArray) {
		this.allServiceInstancesArray = allServiceInstancesArray;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public void run() {
		try {
			JsonObject instance = allServiceInstancesArray.get(instnaceNum).getAsJsonObject();
			// get service name
			String serviceName = instance.getAsJsonObject("spec").getAsJsonObject("provisioning")
					.get("backingservice_name").getAsString();
			String phase = instance.getAsJsonObject("status").get("phase").getAsString();

			if (!phase.equals(Constant.PROVISIONING) && !phase.equals(Constant.FAILURE)) {
				if (Constant.list.contains(serviceName.toLowerCase())) {
					// get service instance name
					String instanceName = instance.getAsJsonObject("metadata").get("name").getAsString();

					// the unassign df and service broker only use the
					// unbinding
					// to do
					// so here not need to call update
					logger.info("unassignRoleFromUserInTenant -> begin to unbinding");
					ResourceResponseBean bindingRes = TenantUtils.removeOCDPServiceCredentials(tenantId, instanceName,
							UserPersistenceWrapper.getUserById(userId).getUsername());

					if (bindingRes.getResCodel() == 201) {
						logger.info("unassignRoleFromUserInTenant -> unbinding successfully");
					}
				}
			}
		} catch (Exception e) {
			// system out the exception into the console log
			logger.info("assignRoleToUserInTenant -> " + e.getMessage());

		}
	}

}
