package com.table.advise.service.impl;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.advise.entity.Advise;
import com.table.advise.service.AdviseService;

import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unused")
@Service("adviseService")
public class AdviseServiceImpl extends BaseService implements AdviseService {

	@Override
	public Advise getAdvise(String id) {
		// TODO Auto-generated method stub
		return dao.getObject(Advise.class, id);
	}

	@Override
	public List<Advise> getAllAdvise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Advise advise) {
		// TODO Auto-generated method stub
		if (null == advise.getId()) {
			dao.saveObject(advise);
		} else {
			dao.updateObject(advise);
		}
	}

	@Override
	public boolean deleteAdvise(String id) {
		// TODO Auto-generated method stub
		Advise user = this.getAdvise(id);
		dao.delete(user);
		return true;
	}

	@Override
	public Pager<Advise> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql = "from Advise";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}

	@Override
	public Advise getAdviseByName(String name) {
		String hql = "from Advise where userName =?";
		return dao.findObject(hql, name);
	}

	public Advise getAdviseByPhone(String tel) {
		String hql = "from Advise where tel=?";
		return dao.findObject(hql, tel);
	}

	public Advise getAdviseByEmail(String email) {
		String hql = "from Advise where email =?";
		return dao.findObject(hql, email);
	}

	public Advise getAdviseById(String adviseId) {
		String hql = "from Advise where id =?";
		return dao.findObject(hql, adviseId);
	}

	@Override
	public void disable(String id) {
		// TODO Auto-generated method stub
		String hql = "update Advise set enable=0 where id=?";
		dao.executeSql(hql, id);
	}
}
