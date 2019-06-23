package com.zhou.mybatis.sqlprovider;

public class UserSqlProvider {
	public String addUser1() {
		String sql = "insert into user(username,pwd,role) values('Jack','666666','5')";
		return sql;
	}
}
