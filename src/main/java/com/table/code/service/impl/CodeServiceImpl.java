package com.table.code.service.impl;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.code.entity.Code;
import com.table.code.service.CodeService;

import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unused")
@Service("codeService")
public class CodeServiceImpl extends BaseService implements CodeService {

	@Override
	public Code getCode(String id) {
		// TODO Auto-generated method stub
		return dao.getObject(Code.class, id);
	}

	@Override
	public List<Code> getAllCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Code code) {
		// TODO Auto-generated method stub
		if (null == code.getId()) {
			dao.saveObject(code);
		} else {
			dao.updateObject(code);
		}
	}

	@Override
	public boolean deleteCode(String id) {
		// TODO Auto-generated method stub
		Code user = this.getCode(id);
		dao.delete(user);
		return true;
	}

	@Override
	public Pager<Code> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql = "from Code";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}

	@Override
	public Code getCodeByName(String name) {
		String hql = "from Code where userName =?";
		return dao.findObject(hql, name);
	}

	public Code getCodeByPhone(String tel) {
		String hql = "from Code where tel=?";
		return dao.findObject(hql, tel);
	}

	public Code getCodeByEmail(String email) {
		String hql = "from Code where email =?";
		return dao.findObject(hql, email);
	}

	public Code getCodeById(String codeId) {
		String hql = "from Code where userId =?";
		return dao.findObject(hql, codeId);
	}

	@Override
	public void disable(String id) {
		// TODO Auto-generated method stub
		String hql = "update Code set enable=0 where id=?";
		dao.executeSql(hql, id);
	}
}
