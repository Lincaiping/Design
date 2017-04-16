package com.table.contract.service.impl;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.contract.entity.Contract;
import com.table.contract.service.ContractService;

import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unused")
@Service("contractService")
public class ContractServiceImpl extends BaseService implements ContractService {

	@Override
	public Contract getContract(String id) {
		// TODO Auto-generated method stub
		return dao.getObject(Contract.class, id);
	}

	@Override
	public List<Contract> getAllContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Contract contract) {
		// TODO Auto-generated method stub
		if (null == contract.getId()) {
			dao.saveObject(contract);
		} else {
			dao.updateObject(contract);
		}
	}

	@Override
	public boolean deleteContract(String id) {
		// TODO Auto-generated method stub
		Contract user = this.getContract(id);
		dao.delete(user);
		return true;
	}

	@Override
	public Pager<Contract> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql = "from Contract";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}

	@Override
	public Contract getContractByName(String name) {
		String hql = "from Contract where userName =?";
		return dao.findObject(hql, name);
	}

	public Contract getContractByPhone(String tel) {
		String hql = "from Contract where tel=?";
		return dao.findObject(hql, tel);
	}

	public Contract getContractByEmail(String email) {
		String hql = "from Contract where email =?";
		return dao.findObject(hql, email);
	}

	public Contract getContractById(String contractId) {
		String hql = "from Contract where id =?";
		return dao.findObject(hql, contractId);
	}

	@Override
	public void disable(String id) {
		// TODO Auto-generated method stub
		String hql = "update Contract set enable=0 where id=?";
		dao.executeSql(hql, id);
	}

	@Override
	public Pager<Contract> getContractByUserId(PageBean pageBean, String userId) {
		// TODO Auto-generated method stub
		String hql = "from Contract where userId =?";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows, userId);
	}
}
