package com.table.manager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 此实体的定义应用了springMvc的注解，省去了传统的Hibernate跟数据库之间的映射配置文件
 * @author gbq
 */
@Entity
@Table(name = "manager")
public class  Manager implements Serializable {
    /**
     * 2016年3月3日
     */
    private static final long serialVersionUID = 1L;

    //指定主键
    @Id  
    //主键自动增长型
    @GeneratedValue 
    @Column(name="Id",length = 11)
    private String id;

    @Column(length = 25)
    private String username;

	@Column(length = 500)
	private String password;

	@Column(length = 25)
	private String tel;

	@Column(length = 25)
	private String email;

	@Column(length = 25)
	private String idNum;

    @Column
    private int type;
    
    @Column
    private int enable;

	@Column(name="last_pass_time",length = 50)
	private String lastPassTime;
    
    @Column(name="pass_count")
    private int passCount;

    @Column(length = 1024)
    private String privateKey;

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPassCount() {
		return passCount;
	}

	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastPassTime() {
		return lastPassTime;
	}

	public void setLastPassTime(String lastPassTime) {
		this.lastPassTime = lastPassTime;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
}
