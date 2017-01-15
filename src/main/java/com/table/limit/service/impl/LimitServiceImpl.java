package com.table.limit.service.impl;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.limit.entity.Limit;
import com.table.limit.service.LimitService;

import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unused")
@Service("limitService")
public class LimitServiceImpl extends BaseService implements LimitService {

	@Override
	public Limit getLimit(String id) {
		// TODO Auto-generated method stub
		return dao.getObject(Limit.class, id);
	}

	@Override
	public List<Limit> getAllLimit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Limit limit) {
		// TODO Auto-generated method stub
		if (null == limit.getId()) {
			dao.saveObject(limit);
		} else {
			dao.updateObject(limit);
		}
	}

	@Override
	public boolean deleteLimit(String id) {
		// TODO Auto-generated method stub
		Limit user = this.getLimit(id);
		dao.delete(user);
		return true;
	}

	@Override
	public Pager<Limit> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql = "from Contract";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}

	@Override
	public Limit getLimitByName(String name) {
		String hql = "from Contract where userName =?";
		return dao.findObject(hql, name);
	}

	public Limit getLimitByPhone(String tel) {
		String hql = "from Contract where tel=?";
		return dao.findObject(hql, tel);
	}

	public Limit getLimitByEmail(String email) {
		String hql = "from Contract where email =?";
		return dao.findObject(hql, email);
	}

	public Limit getLimitById(String limitId) {
		String hql = "from Contract where id =?";
		return dao.findObject(hql, limitId);
	}

	@Override
	public void disable(String id) {
		// TODO Auto-generated method stub
		String hql = "update Contract set enable=0 where id=?";
		dao.executeSql(hql, id);
	}
}
