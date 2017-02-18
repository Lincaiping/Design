package com.table.limit.service.impl;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.limit.entity.ErrorLimit;
import com.table.limit.service.LimitService;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import web.login.entity.PassType;

@SuppressWarnings("unused")
@Service("limitService")
public class LimitServiceImpl extends BaseService implements LimitService {

	@Override
	public ErrorLimit getLimit(String id) {
		// TODO Auto-generated method stub
		return dao.getObject(ErrorLimit.class, id);
	}

	@Override
	public List<ErrorLimit> getAllLimit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(ErrorLimit limit) {
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
		ErrorLimit user = this.getLimit(id);
		dao.delete(user);
		return true;
	}

	@Override
	public Pager<ErrorLimit> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql = "from Contract";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}

	@Override
	public ErrorLimit getLimitByName(String name) {
		String hql = "from ErrorLimit where userName =?";
		return dao.findObject(hql, name);
	}

	public ErrorLimit getLimitByPhone(String tel) {
		String hql = "from ErrorLimit where tel=?";
		return dao.findObject(hql, tel);
	}

	public ErrorLimit getLimitByEmail(String email) {
		String hql = "from ErrorLimit where email =?";
		return dao.findObject(hql, email);
	}

	public ErrorLimit getLimitById(String limitId) {
		String hql = "from ErrorLimit where id =?";
		return dao.findObject(hql, limitId);
	}

	@Override
	public void disable(String id) {
		// TODO Auto-generated method stub
		String hql = "update ErrorLimit set enable=0 where id=?";
		dao.executeSql(hql, id);
	}

	@Override
	public int getCurrentCount(String userId, Integer type) {
		String hql = "from ErrorLimit where userId=? and type=?";

		String currentTime = this.refFormatNowDate();
		int count = dao.countObjects(hql, userId, type);
		if (count == 0) {
			ErrorLimit limit = new ErrorLimit();
			limit.setUserId(userId);
			limit.setType(type);
			limit.setEnable(1);
			limit.setCurrentCount(0);
			limit.setEnableTime(this.refFormatNowDate(PassType.getTime(type)));
			limit.setCurrentTime(currentTime);
			this.saveOrUpdate(limit);
			return 1;
		} else {
			ErrorLimit limit = dao.findObject(hql, userId, type);
			if(limit.getEnable()==0){
				return 100;
			}
			this.countAdd(userId, type);
			return ++count;
		}
	}

	@Override
	public int countAdd(String userId, Integer type) {
		try {
			String hql = "from ErrorLimit where userId=? and type=?";
			ErrorLimit limit = dao.findObject(hql, userId, type);
			limit.setCurrentCount(limit.getCurrentCount() + 1);
			dao.updateObject(limit);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	private String refFormatNowDate(Long time) {
		Date nowTime = new Date(System.currentTimeMillis()+time*60);
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdFormatter.format(nowTime);
	}

	private String refFormatNowDate() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdFormatter.format(nowTime);
	}

	public void disable(String userId, Integer type) {
		String hql = "from ErrorLimit where userId=? and type=?";
		ErrorLimit limit = dao.findObject(hql, userId, type);
		limit.setEnableTime(this.refFormatNowDate(PassType.getTime(type)));
		limit.setEnable(0);
		this.saveOrUpdate(limit);
	}
}
