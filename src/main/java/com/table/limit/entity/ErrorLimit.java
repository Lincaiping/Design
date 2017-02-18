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
@Table(name = "error_limit")
public class ErrorLimit implements Serializable {
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
	private int enable;

	@Column(name = "now_time",length = 100)
	private String currentTime;

	@Column(name = "enable_time",length = 100)
	private String enableTime;

	@Column(length = 3)
	private int type;

	@Column(length = 3)
	private int count;

	@Column(name = "current_count",length = 11)
	private int currentCount;

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

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
