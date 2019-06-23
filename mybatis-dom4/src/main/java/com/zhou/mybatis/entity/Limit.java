package com.zhou.mybatis.entity;

public class Limit {
	private int id;
	private String name;
	private String url;
	private int parent_limit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getParent_limit() {
		return parent_limit;
	}

	public void setParent_limit(int parent_limit) {
		this.parent_limit = parent_limit;
	}

}
