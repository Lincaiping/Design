package com.table.contract.controller;

import com.base.BaseController;
import com.base.HttpUtils;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.contract.entity.Contract;
import com.table.contract.service.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/contract")
public class ContractController extends BaseController {

	/*
	 * 在配置文件中， userContract会绑定bean中id为userContract的类 有注解就不需要set方法
	 */
	@Autowired
	private ContractService contractService;

	@RequestMapping("/goList")
	public String goList() {
		return "table/contract/list";
	}

	@RequestMapping("/getAllContract")
	@ResponseBody
	public Pager<Contract> getAllContract(Integer page, Integer rows) {
		PageBean pageBean = new PageBean();
		pageBean.setPageNo(page);
		pageBean.setPageSize(rows);
		return contractService.getByPage(pageBean);
	}

	@RequestMapping("/getContract")
	public String getContract(String id, HttpServletRequest request) {
		request.setAttribute("contract", contractService.getContract(id));
		return "/editContract";
	}

	@RequestMapping("/toAddContract")
	public String toAddContract() {
		return "/addContract";
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public boolean saveOrUpdate(Contract contract) {
		contract.setCreateTime(HttpUtils.getTime());
		contractService.saveOrUpdate(contract);
		return true;
	}

	@RequestMapping("/loginOut_contract")
	@ResponseBody
	public boolean loginOut_contract(HttpServletRequest request) {
		HttpSession session = HttpUtils.getSession(request);
		session.invalidate();
		return true;
	}

	@RequestMapping("/delContract")
	public void delContract(String id, HttpServletResponse response) {

		String result = "{\"result\":\"error\"}";

		if (contractService.deleteContract(id)) {
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
