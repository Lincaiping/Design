package com.table.code.service;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.code.entity.Code;

import java.util.List;

@SuppressWarnings("unused")
public interface CodeService {
	Code getCode(String id);

	List<Code> getAllCode();

	void saveOrUpdate(Code code);

	boolean deleteCode(String id);

	Pager<Code> getByPage(PageBean pageBean);

	Code getCodeByName(String name);

	void disable(String id);

	Code getCodeByPhone(String tel);

	Code getCodeByEmail(String email);

	Code getCodeById(String userId);

}
