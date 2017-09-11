package com.avit.mybatis.bean;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AlarmConfig {
	private int id;
	private String configname;
	private String configvalue;
	private String description;
	private String configquery;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConfigname() {
		return configname;
	}

	public void setConfigname(String configname) {
		this.configname = configname;
	}

	public String getConfigvalue() {
		return configvalue;
	}

	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConfigquery() {
		return configquery;
	}

	public void setConfigquery(String configquery) {
		this.configquery = configquery;
	}
	
	public String  toString()
	{
		return "AlarmConfig  [configname="+getConfigname()+",configvalue="+getConfigvalue()
				+",description="+getDescription()+",configquery="+getConfigquery()+"]";
	}
	
}
