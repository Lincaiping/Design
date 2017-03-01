package web.house.controller;

import com.base.BaseController;
import com.mysql.jdbc.log.LogUtils;
import com.table.house.entity.House;
import com.table.house.service.HouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		}
		else {
			model.addAttribute("imageList", null);
		}
		model.addAttribute("house", house);
		return "/web/houseDetail";
	}

	@RequestMapping("/toEditHouse")
	public String toEditHouse(HttpServletRequest request, Model model, String houseId) {
		House house = houseService.getHouse(houseId);
		model.addAttribute("house", house);
		return "/web/rent/rent_edit";
	}
}
