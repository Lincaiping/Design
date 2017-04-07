package com.table.house.service;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.house.entity.House;

import java.util.List;

@SuppressWarnings("unused")
public interface HouseService {
	House getHouse(String id);

	List<House> getAllHouse();

	void saveOrUpdate(House house);

	boolean deleteHouse(String id);

	Pager<House> getByPage(PageBean pageBean);

	House getHouseByName(String name);

	void disable(String id);

	House getHouseByPhone(String tel);

	House getHouseByEmail(String email);

	House getHouseById(String userId);

	List<House> getHouseByOwnerId(String userId);

	Pager<House> getSelectHouse(PageBean pageBean,String location,String type);
}
