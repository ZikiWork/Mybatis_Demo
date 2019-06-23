package com.zhou.mybatis.dao;

import java.util.List;
import com.zhou.mybatis.entity.User;

public interface UserDAO {
	public List<User> getUserByCondition(User user);

	public List<User> getUserByCondition2(String username, String pwd);

	public List<User> getUserByName(String username);

	public List<User> getUserByCondition3(User user);

	public void updateUser(User user);

	public void updateUser2(User user);

	public List<User> getUserByIds(int[] ids);

	public List<User> getUserByIds2(List<Integer> ids);
}