package web.house.controller;

import com.base.BaseController;
import com.base.HttpUtils;
import com.table.house.entity.House;
import com.table.house.service.HouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sun.rmi.runtime.Log;
import web.Define;

/**
 * Created by gbq on 2017/2/27.
 */
@Controller
@RequestMapping("/webHouse")
public class WebHouseController extends BaseController {
	@Autowired
	private HouseService houseService;

	@RequestMapping("/rentHouse")
	public String rentHouse(HttpServletRequest request, House house) {
		System.out.print("rentHouse");
		String userId = (String) request.getSession().getAttribute("userId");
		if (userId != null) {
			house.setOwner(userId);
		}
		houseService.saveOrUpdate(house);
		return "success";
	}

	@RequestMapping("/toHouseDetail")
	public String toHouseDetail(HttpServletRequest request, Model model, String houseId) {
		House house = houseService.getHouse(houseId);
		String houseImage = house.getImage();
		if (houseImage != null && !houseImage.equals("")) {
			String[] imageList = house.getImage().split(",");
			List list = Arrays.asList(imageList);
			model.addAttribute("imageList", list);
		} else {
			model.addAttribute("imageList", null);
		}
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute(Define.USER_ID);
		System.err.println(userId);
		if(userId!=null) {
			model.addAttribute("owner", userId.equals(house.getOwner()));
		}
		else {
			model.addAttribute("owner", null);
		}
		model.addAttribute("house", house);
		return "/web/houseDetail";
	}

	@RequestMapping("/toEditHouse")
	public String toEditHouse(HttpServletRequest request, Model model, String houseId) {
		House house = houseService.getHouse(houseId);
		HttpSession session = HttpUtils.getSession(request);
		session.setAttribute("houseId", houseId);
		model.addAttribute("house", house);

		return "/web/rent/rent_edit";
	}
}
