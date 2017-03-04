package web.login.controller;

import com.base.BaseController;
import com.base.dao.PageBean;
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

import web.index.service.IndexService;
import web.login.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private IndexService indexService;
	@Autowired
	private UserService userService;

	@Autowired
	private HouseService houseService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, String userName, String password, Model model) {
		User user = loginService.userLogin(request, userName, password, null);
		if (!indexService.limitAble(request, 1)) {
			return "404";
		}
		if (null != user) {
			model.addAttribute("image", user.getImage());
			model.addAttribute("tel", user.getTel());
			model.addAttribute("email", user.getEmail());
			model.addAttribute("idNum", user.getIdNum());
			PageBean pageBean = new PageBean();
			pageBean.setPageNo(0);
			pageBean.setPageSize(20);
			List<House> houseList = houseService.getByPage(pageBean).getRows();
			model.addAttribute("houseList", houseList);
			return "web/index";
		}
		return "404";
	}

	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request) {
		log.debug("转到登录页面!");
		return "web/login/login";
	}

	@RequestMapping("/toIndex")
	public String toIndex(HttpServletRequest request) {
		log.debug("转到主页面!");
		return "/";
	}

	@RequestMapping("/userOut")
	public String loginOut(HttpServletRequest request) {
		if (loginService.loginOut(request)) {
			log.debug("退出登录");
			return "web/login/login";
		}
		return "404";
	}

	@RequestMapping("/toRegister")
	public String toRegister() {
		return "web/login/register";
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request, String userName, String tel, String password, String code, Model model)
			throws Exception {
		if (!indexService.checkCodeByTel(tel, code)) {
			return "404";
		}
		if (loginService.register(userName, tel, password)) {
			model.addAttribute("userName", userName);
			return "web/login/showResult";
		}
		return "404";
	}

	@RequestMapping("/toReset")
	public String toReset(HttpServletRequest request) {
		return "web/login/reset";
	}

	@RequestMapping("/resetTel")
	@ResponseBody
	public String resetTel(HttpServletRequest request, String tel, String code, String password) {
		User user = userService.getUserByPhone(tel);
		if (!indexService.resetCode(user.getId(), code)) {
			return "error";
		} else {
			if (!loginService.resetPassword(user, password)) {
				return "error";
			}
		}
		return "success";
	}

	@RequestMapping("/toResetEmail")
	public String toResetEmail(HttpServletRequest request) {
		return "web/login/resetEmail";
	}

	@RequestMapping("/resetEmail")
	@ResponseBody
	public String resetEmail(HttpServletRequest request, String email, String code, String password) {
		User user = userService.getUserByEmail(email);
		if (!indexService.resetCode(user.getId(), code)) {
			return "error";
		} else {
			if (!loginService.resetPassword(user, password)) {
				return "error";
			}
		}
		return "success";
	}
}
