package com.table.limit.controller;

import com.base.BaseController;
import com.base.HttpUtils;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.limit.entity.Limit;
import com.table.limit.service.LimitService;

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
@RequestMapping("/limit")
public class LimitController extends BaseController {

	/*
	 * 在配置文件中， userLimit会绑定bean中id为userLimit的类 有注解就不需要set方法
	 */
	@Autowired
	private LimitService limitService;

	@RequestMapping("/goList")
	public String goList() {
		return "table/limit/list";
	}

	@RequestMapping("/getAllLimit")
	@ResponseBody
	public Pager<Limit> getAllLimit(Integer page, Integer rows) {
		PageBean pageBean = new PageBean();
		pageBean.setPageNo(page);
		pageBean.setPageSize(rows);
		return limitService.getByPage(pageBean);
	}

	@RequestMapping("/getLimit")
	public String getLimit(String id, HttpServletRequest request) {
		request.setAttribute("limit", limitService.getLimit(id));
		return "/editLimit";
	}

	@RequestMapping("/toAddLimit")
	public String toAddLimit() {
		return "/addLimit";
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public boolean saveOrUpdate(Limit limit) {
		limitService.saveOrUpdate(limit);
		return true;
	}

	@RequestMapping("/loginOut_limit")
	@ResponseBody
	public boolean loginOut_limit(HttpServletRequest request) {
		HttpSession session = HttpUtils.getSession(request);
		session.invalidate();
		return true;
	}

	@RequestMapping("/delLimit")
	public void delLimit(String id, HttpServletResponse response) {

		String result = "{\"result\":\"error\"}";

		if (limitService.deleteLimit(id)) {
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
