package com.zhou.mybatis.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhou.mybatis.dao.RoleDAO;
import com.zhou.mybatis.dao.RoleLimitDAO;
import com.zhou.mybatis.entity.Role;

//主从表同时进行操作。
public class RoleService {
	public void addRole(Role role, int[] limits) {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RoleDAO roleDAO = sqlSession.getMapper(RoleDAO.class);
		RoleLimitDAO roleLimitDAO = sqlSession.getMapper(RoleLimitDAO.class);
		roleDAO.addRole(role);
		int addId = role.getId();
		System.out.println(addId);
		for (int i : limits) {
			roleLimitDAO.addRoleLimit(addId, i);
		}
		sqlSession.commit();
	}

	public void deleteRole(int role) {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RoleDAO roleDAO = sqlSession.getMapper(RoleDAO.class);
		RoleLimitDAO roleLimitDAO = sqlSession.getMapper(RoleLimitDAO.class);
		roleLimitDAO.deleteRoleLimit(role);
		roleDAO.deleteRole(role);
		sqlSession.commit();//增加事务
	}
}
