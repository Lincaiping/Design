package com.table.contract.service;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.contract.entity.Contract;

import java.util.List;

@SuppressWarnings("unused")
public interface ContractService {
	Contract getContract(String id);

	List<Contract> getAllContract();

	void saveOrUpdate(Contract contract);

	boolean deleteContract(String id);

	Pager<Contract> getByPage(PageBean pageBean);

	Contract getContractByName(String name);

	void disable(String id);

	Contract getContractByPhone(String tel);

	Contract getContractByEmail(String email);

	Contract getContractById(String userId);

	Pager<Contract> getContractByUserId(PageBean pageBean,String userId);
}
