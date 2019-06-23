package com.zhou.mybatis.dao;

public interface RoleLimitDAO {
	public void addRoleLimit(int role_id, int limit_id);

	public void deleteRoleLimit(int role);
}
