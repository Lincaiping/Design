package com.table.limit.service;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.limit.entity.Limit;

import java.util.List;

@SuppressWarnings("unused")
public interface LimitService {
	Limit getLimit(String id);

	List<Limit> getAllLimit();

	void saveOrUpdate(Limit limit);

	boolean deleteLimit(String id);

	Pager<Limit> getByPage(PageBean pageBean);

	Limit getLimitByName(String name);

	void disable(String id);

	Limit getLimitByPhone(String tel);

	Limit getLimitByEmail(String email);

	Limit getLimitById(String userId);

}
