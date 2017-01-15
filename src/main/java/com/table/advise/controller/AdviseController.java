package com.table.advise.controller;

import com.base.BaseController;
import com.base.HttpUtils;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.advise.entity.Advise;
import com.table.advise.service.AdviseService;

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
@RequestMapping("/advise")
public class AdviseController extends BaseController {

	/*
	 * 在配置文件中， userAdvise会绑定bean中id为userAdvise的类 有注解就不需要set方法
	 */
	@Autowired
	private AdviseService adviseService;

	@RequestMapping("/goList")
	public String goList() {
		return "table/advise/list";
	}

	@RequestMapping("/getAllAdvise")
	@ResponseBody
	public Pager<Advise> getAllAdvise(Integer page, Integer rows) {
		PageBean pageBean = new PageBean();
		pageBean.setPageNo(page);
		pageBean.setPageSize(rows);
		return adviseService.getByPage(pageBean);
	}

	@RequestMapping("/getAdvise")
	public String getAdvise(String id, HttpServletRequest request) {
		request.setAttribute("advise", adviseService.getAdvise(id));
		return "/editAdvise";
	}

	@RequestMapping("/toAddAdvise")
	public String toAddAdvise() {
		return "/addAdvise";
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public boolean saveOrUpdate(Advise advise) {
		adviseService.saveOrUpdate(advise);
		return true;
	}

	@RequestMapping("/loginOut_advise")
	@ResponseBody
	public boolean loginOut_advise(HttpServletRequest request) {
		HttpSession session = HttpUtils.getSession(request);
		session.invalidate();
		return true;
	}

	@RequestMapping("/delAdvise")
	public void delAdvise(String id, HttpServletResponse response) {

		String result = "{\"result\":\"error\"}";

		if (adviseService.deleteAdvise(id)) {
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
