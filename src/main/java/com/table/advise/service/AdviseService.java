package com.table.advise.service;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.advise.entity.Advise;

import java.util.List;

@SuppressWarnings("unused")
public interface AdviseService {
	Advise getAdvise(String id);

	List<Advise> getAllAdvise();

	void saveOrUpdate(Advise advise);

	boolean deleteAdvise(String id);

	Pager<Advise> getByPage(PageBean pageBean);

	Advise getAdviseByName(String name);

	void disable(String id);

	Advise getAdviseByPhone(String tel);

	Advise getAdviseByEmail(String email);

	Advise getAdviseById(String userId);

}
