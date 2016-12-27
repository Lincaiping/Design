package com.table.user.service;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.user.entity.User;

import java.util.List;

public interface UserService {
	public User getUser(String id) ;
	
	public List<User> getAllUser();
	
	public void saveOrUpdate(User user);
	
	public boolean deleteUser(String id);
	
	public Pager<User> getByPage(PageBean pageBean);
	
	public User getUserByName(String name);

	public void disable(String id);

	public User getUserByPhone(String tel);

	public User getUserByEmail(String email);

	public User getUserById(String userId);
		
}
