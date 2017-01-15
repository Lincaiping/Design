package com.table.limit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 房子的实体
 * Created by linCP on 2017/1/1.
 */
@Entity
@Table(name = "limit")
public class Limit implements Serializable {
	private static final long serialVersionUID = 1L;

	//指定主键
	@Id
	//主键自动增长型
	@GeneratedValue
	@Column(name = "Id", length = 11)
	private String id;

	@Column(name = "user_id", length = 50)
	private String userId;

	@Column(length = 10)
	private String enable;

	@Column(name = "current_time",length = 50)
	private String currentTime;

	@Column(name = "enable_time",length = 50)
	private String enableTime;

	@Column(length = 10)
	private int code;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getEnableTime() {
		return enableTime;
	}

	public void setEnableTime(String enableTime) {
		this.enableTime = enableTime;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
