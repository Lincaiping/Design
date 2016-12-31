package com.table.manager.service;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.manager.entity.Manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ManagerService {
	 Manager getManager(String id) ;
	
	 @SuppressWarnings("unused")
	 List<Manager> getAllManager();
	
	 void saveOrUpdate(Manager manager);
	
	 boolean deleteManager(String id);
	
	 Pager<Manager> getByPage(PageBean pageBean);

	 boolean login(HttpServletRequest request, String userName, String password);

	 void disableThis(HttpServletRequest request);
	
	 Manager getManagerByName(String userName);
}
