package com.zhou.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.zhou.mybatis.dao.UserDAO;
import com.zhou.mybatis.entity.User;

public class TestUser {

	SqlSession sqlSession = null;
	UserDAO userDAO = null;

	@Before
	public void before() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession();
		userDAO = sqlSession.getMapper(UserDAO.class);
	}

	@After
	public void after() {
		sqlSession.commit();
	}

	// 按条件查询
	@Test
	public void testSelectUser3() throws IOException {
		User user = new User();
		// user.setUsername("Tom");
		user.setRole("5");
		userDAO.getUserByCondition(user).forEach(e -> System.out.println(e));
	}

	@Test
	public void testGetCondition() {
		userDAO.getUserByCondition2("Tom", "666666").forEach(e -> System.out.println(e));
	}

	@Test
	public void testGetUserByName() {
		userDAO.getUserByName("T ").forEach(e -> System.out.println(e));

	}

	@Test
	public void testUpdateUser() throws Exception {
		User user = new User();
		user.setId(4);
		user.setUsername("lili");
		user.setPwd("555555");
		userDAO.updateUser(user);
	}

	@Test
	public void testUpdateUser2() {
		User user = new User();
		user.setId(5);
		user.setUsername("老王");
		user.setPwd("555555");
		userDAO.updateUser(user);
	}

	@Test
	public void testGetUserByIds() {
		userDAO.getUserByIds(new int[] { 1, 3, 6, 7 }).forEach(e -> System.out.println(e));
	}

	/**
	 * 动态SQL foreach()使用List
	 */
	@Test
	public void testGetUserByIds2() {
		userDAO.getUserByIds2(Arrays.asList(1, 2, 6)).forEach(e -> System.out.println(e));
	}
}
