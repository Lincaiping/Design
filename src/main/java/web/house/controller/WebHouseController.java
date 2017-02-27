package web.house.controller;

import com.base.BaseController;
import com.mysql.jdbc.log.LogUtils;
import com.table.house.entity.House;
import com.table.house.service.HouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String rentHouse(HttpServletRequest request,House house){
		System.out.print("rentHouse");
		String userId  = (String) request.getSession().getAttribute("userId");
		if(userId != null) {
			house.setOwner(userId);
		}
		houseService.saveOrUpdate(house);
		return "success";
	}
}
