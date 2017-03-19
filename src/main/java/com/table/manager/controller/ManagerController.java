package com.table.manager.controller;

import com.base.BaseController;
import com.base.HttpUtils;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.manager.entity.Manager;
import com.table.manager.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.Define;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/managers")
public class ManagerController extends BaseController {

	/*
	 * 在配置文件中， userManager会绑定bean中id为userManager的类 有注解就不需要set方法
	 */
	@Autowired
	private ManagerService managerService;

	@RequestMapping("/top")
	public String top(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		model.addAttribute("managerName", session.getAttribute("managerName"));
		return "top";
	}

	@RequestMapping("/index2")
	public String index2(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String managerName = (String) session.getAttribute("managerName");
		Manager manager = managerService.getManagerByName(managerName);
		model.addAttribute("lastPassTime", manager.getLastPassTime());
		model.addAttribute("managerName", managerName);
		return "index2";
	}

	@RequestMapping("/goList")
	public String goList() {
		return "table/manager/list";
	}

	@RequestMapping("/toManage")
	public String toManage() {
		return "manager";
	}

	@RequestMapping("/getAllManager")
	@ResponseBody
	public Pager<Manager> getAllManager(Integer page, Integer rows) {
		PageBean pageBean = new PageBean();
		pageBean.setPageNo(page);
		pageBean.setPageSize(rows);
		return managerService.getByPage(pageBean);
	}

	@RequestMapping("/getManager")
	public String getManager(String id, HttpServletRequest request) {
		request.setAttribute("manager", managerService.getManager(id));
		return "/editManager";
	}

	@RequestMapping("/toAddManager")
	public String toAddManager() {
		return "/addManager";
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public boolean saveOrUpdate(Manager manager) {
		managerService.saveOrUpdate(manager);
		return true;
	}

	@RequestMapping("/loginOut_manager")
	@ResponseBody
	public boolean loginOut_manager(HttpServletRequest request) {
		HttpSession session = HttpUtils.getSession(request);
		session.invalidate();
		return true;
	}

	@RequestMapping("/disableThis")
	@ResponseBody
	public boolean disableThis(HttpServletRequest request) {
		managerService.disableThis(request);
		return true;
	}

	@RequestMapping("/delManager")
	public void delManager(String id, HttpServletResponse response) {

		String result = "{\"result\":\"error\"}";

		if (managerService.deleteManager(id)) {
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
