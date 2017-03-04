package web.personal.controller;

import com.base.BaseController;
import com.base.HttpUtils;
import com.base.dao.PageBean;
import com.base.idCard.IdcardValidator;
import com.table.house.entity.House;
import com.table.house.service.HouseService;
import com.table.user.entity.User;
import com.table.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.index.service.IndexService;

@Controller
@RequestMapping("/personal")
public class PersonalController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private IndexService indexService;

	@Autowired
	private HouseService houseService;

	@RequestMapping("/toPersonal")
	public String toPersonal(HttpServletRequest request) {
		return "web/personal/personal";
	}
	
	@RequestMapping("/deleteAccount")
	public String deleteAccount(HttpServletRequest request) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		User user = userService.getUser(userId);
		user.setEnable(0);
		userService.saveOrUpdate(user);
		return "success";
	}

	@RequestMapping("/codeManage")
	public String codeManage(HttpServletRequest request, Integer page, Integer rows, Model model) {
		return "table/records/list";
	}

	@RequestMapping("/update")
	public boolean update(HttpServletRequest request, User user) {
		userService.saveOrUpdate(user);
		return true;
	}

	@RequestMapping("/delete")
	public boolean delete(HttpServletRequest request, String id) {
		userService.disable(id);
		return true;
	}

	@RequestMapping("realName")
	public String viewIDCard(HttpServletRequest request, Model model) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		User user = userService.getUser(userId);
		String realName = user.getRealName();
		String idNum = user.getIdNum();
		model.addAttribute("realName", realName);
		model.addAttribute("idNum", idNum);
		return "web/personal/realName";
	}

	@RequestMapping("viewPhone")
	public String viewPhone(HttpServletRequest request, Model model) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		User user = userService.getUser(userId);
		String tel = user.getTel();
		model.addAttribute("tel", tel);
		return "web/personal/contactTel";
	}

	@RequestMapping("setPhone")
	@ResponseBody
	public String setPhone(HttpServletRequest request, String phone, String code) {
		if (!indexService.checkCode(request, code)) {
			return "error";
		} else {
			HttpSession session = HttpUtils.getSession(request);
			String userId = (String) session.getAttribute("userId");
			User user = userService.getUser(userId);
			user.setTel(phone);
			userService.saveOrUpdate(user);
			return "success";
		}

	}

	@RequestMapping("viewEmail")
	public String viewEmail(HttpServletRequest request, Model model) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		User user = userService.getUser(userId);
		String email = user.getEmail();
		model.addAttribute("email", email);
		return "web/personal/contactEmail";
	}

	@RequestMapping("uploadImg")
	public String uploadImg(HttpServletRequest request) {
		return "web/personal/image";
	}

	@RequestMapping("setEmail")
	@ResponseBody
	public String setEmail(HttpServletRequest request, String email, String code) {
		if (!indexService.checkCode(request, code)) {
			return "error";
		} else {
			HttpSession session = HttpUtils.getSession(request);
			String userId = (String) session.getAttribute("userId");
			User user = userService.getUser(userId);
			user.setEmail(email);
			userService.saveOrUpdate(user);
			return "success";
		}
	}

	@RequestMapping("setIDCard")
	@ResponseBody
	public String setIDCard(HttpServletRequest request, String idNum,String realName) {
		IdcardValidator idcardValidator =new IdcardValidator();
		if(idNum.length()!=18||!idcardValidator.isValidatedAllIdcard(idNum)){
			return "error";
		}
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		User user = userService.getUser(userId);
		user.setIdNum(idNum);
		user.setRealName(realName);
		userService.saveOrUpdate(user);
		return "success";
	}

	@RequestMapping("/myHouse")
	public String myHouse(HttpServletRequest request, Model model) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		List<House> houseList = houseService.getHouseByOwnerId(userId);
		model.addAttribute("houseList", houseList);
		return "web/index";
	}

	@RequestMapping("/toRendOut")
	public String toRendOut() {
		return "web/rent/rent_out";
	}
}
