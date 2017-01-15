package com.table.code.controller;

import com.base.BaseController;
import com.base.HttpUtils;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.code.entity.Code;
import com.table.code.service.CodeService;

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
@RequestMapping("/code")
public class CodeController extends BaseController {

	/*
	 * 在配置文件中， userCode会绑定bean中id为userCode的类 有注解就不需要set方法
	 */
	@Autowired
	private CodeService codeService;

	@RequestMapping("/goList")
	public String goList() {
		return "table/code/list";
	}

	@RequestMapping("/getAllCode")
	@ResponseBody
	public Pager<Code> getAllCode(Integer page, Integer rows) {
		PageBean pageBean = new PageBean();
		pageBean.setPageNo(page);
		pageBean.setPageSize(rows);
		return codeService.getByPage(pageBean);
	}

	@RequestMapping("/getCode")
	public String getCode(String id, HttpServletRequest request) {
		request.setAttribute("code", codeService.getCode(id));
		return "/editCode";
	}

	@RequestMapping("/toAddCode")
	public String toAddCode() {
		return "/addCode";
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public boolean saveOrUpdate(Code code) {
		codeService.saveOrUpdate(code);
		return true;
	}

	@RequestMapping("/loginOut_code")
	@ResponseBody
	public boolean loginOut_code(HttpServletRequest request) {
		HttpSession session = HttpUtils.getSession(request);
		session.invalidate();
		return true;
	}

	@RequestMapping("/delCode")
	public void delCode(String id, HttpServletResponse response) {

		String result = "{\"result\":\"error\"}";

		if (codeService.deleteCode(id)) {
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
