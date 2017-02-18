package com.table.limit.service;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.limit.entity.ErrorLimit;

import java.util.List;

@SuppressWarnings("unused")
public interface LimitService {
	ErrorLimit getLimit(String id);

	List<ErrorLimit> getAllLimit();

	void saveOrUpdate(ErrorLimit limit);

	boolean deleteLimit(String id);

	Pager<ErrorLimit> getByPage(PageBean pageBean);

	ErrorLimit getLimitByName(String name);

	void disable(String id);

	ErrorLimit getLimitByPhone(String tel);

	ErrorLimit getLimitByEmail(String email);

	ErrorLimit getLimitById(String userId);

	int getCurrentCount(String userId, Integer type);

	int countAdd(String userId, Integer type);

	void disable(String userId, Integer type);
}
