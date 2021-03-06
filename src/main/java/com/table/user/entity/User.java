package com.table.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 此实体的定义应用了springmvc的注解，省去了传统的Hibernate跟数据库之间的映射配置文件
 *
 * @author gbq
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "user")
public class User implements Serializable {
	/**
	 * 2016年3月3日
	 */
	private static final long serialVersionUID = 1L;

	//指定主键
	@Id
	//主键自动增长型
	@GeneratedValue
	@Column(name = "Id", length = 11)
	private String id;

	@Column(name = "user_name", length = 50)
	private String userName;

	@Column(length = 300)
	private String password;

	@Column(length = 30)
	private String tel;

	@Column(length = 25)
	private String email;

	@Column(name = "create_time", length = 25)
	private String createTime;

	@Column(name = "id_num", length = 25)
	private String idNum;

	@Column(name = "real_name", length = 50)
	private String realName;

	@Column(length = 4)
	private int enable;


	@Column(length = 50)
	private String image;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int isEnable() {
		return enable;
	}

	@SuppressWarnings("SameParameterValue")
	public void setEnable(int enable) {
		this.enable = enable;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getEnable() {
		return enable;
	}
}
