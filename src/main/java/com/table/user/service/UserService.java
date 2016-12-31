package com.table.user.service;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.user.entity.User;

import java.util.List;

@SuppressWarnings("unused")
public interface UserService {
	User getUser(String id);

	List<User> getAllUser();

	void saveOrUpdate(User user);

	boolean deleteUser(String id);

	Pager<User> getByPage(PageBean pageBean);

	User getUserByName(String name);

	void disable(String id);

	User getUserByPhone(String tel);

	User getUserByEmail(String email);

	User getUserById(String userId);

}
