package com.table.house.service.impl;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.house.entity.House;
import com.table.house.service.HouseService;

import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unused")
@Service("userService")
public class HouseServiceImpl extends BaseService implements HouseService {
	
	@Override
	public House getHouse(String id) {
		// TODO Auto-generated method stub
		return dao.getObject(House.class, id);
	}

	@Override
	public List<House> getAllHouse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(House house) {
		// TODO Auto-generated method stub
		if (null==house.getId()) {
			dao.saveObject(house);
		}
		else {
			dao.updateObject(house);
		}
	}

	@Override
	public boolean deleteHouse(String id) {
		// TODO Auto-generated method stub
		House user = this.getHouse(id);
		dao.delete(user);
		return true;
	}

	@Override
	public Pager<House> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql="from House";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}
	
	@Override
	public House getHouseByName(String name){
		String hql = "from House where userName =?";
		return dao.findObject(hql, name);
	}
	
	public House getHouseByPhone(String tel){
		String hql = "from House where tel=?";
		return dao.findObject(hql, tel);
	}
	
	public House getHouseByEmail(String email){
		String hql = "from House where email =?";
		return dao.findObject(hql, email);
	}
	
	public House getHouseById(String houseId){
		String hql = "from House where id =?";
		return dao.findObject(hql, houseId);
	}









	@Override
	public void disable(String id) {
		// TODO Auto-generated method stub
		String hql = "update House set enable=0 where id=?";
		dao.executeSql(hql, id);
	}
}
