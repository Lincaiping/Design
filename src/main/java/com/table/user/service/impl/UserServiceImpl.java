package com.table.user.service.impl;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.user.entity.User;
import com.table.user.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unused")
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {
	
	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return dao.getObject(User.class, id);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		if (null==user.getId()||user.getId().equals("")) {
			user.setEnable(1);
			dao.saveObject(user);
		}
		else {
			dao.updateObject(user);
		}
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		User user = this.getUser(id);
		dao.delete(user);
		return true;
	}

	@Override
	public Pager<User> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql="from User";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}
	
	@Override
	public User getUserByName(String name){
		String hql = "from User where userName =?";
		return dao.findObject(hql, name);
	}
	
	public User getUserByPhone(String tel){
		String hql = "from User where tel=?";
		return dao.findObject(hql, tel);
	}
	
	public User getUserByEmail(String email){
		String hql = "from User where email =?";
		return dao.findObject(hql, email);
	}
	
	public User getUserById(String userId){
		String hql = "from User where id =?";
		return dao.findObject(hql, userId);
	}

	@Override
	public void disable(String id) {
		// TODO Auto-generated method stub
		String hql = "update User set enable=0 where id=?";
		dao.executeSql(hql, id);
	}
}
