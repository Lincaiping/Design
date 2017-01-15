package com.table.house.controller;

import com.base.BaseController;
import com.base.HttpUtils;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.house.entity.House;
import com.table.house.service.HouseService;

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
@RequestMapping("/house")
public class HouseController extends BaseController {

	/*
	 * 在配置文件中， userHouse会绑定bean中id为userHouse的类 有注解就不需要set方法
	 */
	@Autowired
	private HouseService houseService;

	@RequestMapping("/goList")
	public String goList() {
		return "table/house/list";
	}

	@RequestMapping("/getAllHouse")
	@ResponseBody
	public Pager<House> getAllHouse(Integer page, Integer rows) {
		PageBean pageBean = new PageBean();
		pageBean.setPageNo(page);
		pageBean.setPageSize(rows);
		return houseService.getByPage(pageBean);
	}

	@RequestMapping("/getHouse")
	public String getHouse(String id, HttpServletRequest request) {
		request.setAttribute("house", houseService.getHouse(id));
		return "/editHouse";
	}

	@RequestMapping("/toAddHouse")
	public String toAddHouse() {
		return "/addHouse";
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public boolean saveOrUpdate(House house) {
		houseService.saveOrUpdate(house);
		return true;
	}

	@RequestMapping("/loginOut_house")
	@ResponseBody
	public boolean loginOut_house(HttpServletRequest request) {
		HttpSession session = HttpUtils.getSession(request);
		session.invalidate();
		return true;
	}

	@RequestMapping("/delHouse")
	public void delHouse(String id, HttpServletResponse response) {

		String result = "{\"result\":\"error\"}";

		if (houseService.deleteHouse(id)) {
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
