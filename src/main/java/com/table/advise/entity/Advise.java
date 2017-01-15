package com.table.advise.entity;

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
@Table(name = "advise")
public class Advise implements Serializable {
	private static final long serialVersionUID = 1L;

	//指定主键
	@Id
	//主键自动增长型
	@GeneratedValue
	@Column(name = "Id", length = 11)
	private String id;

	@Column(name = "user_id", length = 50)
	private String userId;

	@Column(length = 200)
	private String title;

	@Column(length = 200)
	private String describle;

	@Column(length = 25)
	private String tel;


	@Column(length = 100)
	private String emai;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescrible() {
		return describle;
	}

	public void setDescrible(String describle) {
		this.describle = describle;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmai() {
		return emai;
	}

	public void setEmai(String emai) {
		this.emai = emai;
	}
}
