package com.asiainfo.ocmanager.rest.resource.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.asiainfo.ocmanager.persistence.mapper.UserRoleMapper;
import com.asiainfo.ocmanager.persistence.model.UserRoleView;
import com.asiainfo.ocmanager.persistence.DBConnectorFactory;

/**
 * 
 * @author zhaoyim
 *
 */
public class UserRoleViewPersistenceWrapper {
	
	/**
	 * 
	 * @param tenantId
	 * @return
	 */
	public static List<UserRoleView> getUsersInTenant(String tenantId) {
		SqlSession session = DBConnectorFactory.getSession();
		List<UserRoleView> usersWithRoles = new ArrayList<UserRoleView>();
		try {
			UserRoleMapper mapper = session.getMapper(UserRoleMapper.class);
			usersWithRoles = mapper.selectUsersRolesInTenant(tenantId);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return usersWithRoles;
	}
	
	
	
	/**
	 * 
	 * @param userName
	 * @param tenantId
	 * @return
	 */
	public static UserRoleView getRoleBasedOnUserAndTenant(String userName, String tenantId) {
		SqlSession session = DBConnectorFactory.getSession();
		UserRoleView RUT = new UserRoleView();
		try {
			UserRoleMapper mapper = session.getMapper(UserRoleMapper.class);
			RUT = mapper.selectRoleBasedOnUserAndTenant(userName, tenantId);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return RUT;
	}
	
	
}