package web.login.controller;

import com.base.BaseController;
import com.base.HttpUtils;
import com.table.manager.service.ManagerService;
import com.table.user.entity.User;
import com.table.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.Define;
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
	private ManagerService managerService;

	@ResponseBody
	@RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request, String userName, String password, Model model) {
		User user = loginService.userLogin(request, userName, password, null);
		if (!indexService.limitAble(request, 1)) {
			return Define.ERROR_LIMIT;
		}
		if (null != user) {
			return Define.RESULT_SUCCESS;
		}
		return Define.ERROR_PASSWORD;
	}

	@RequestMapping("/toLogin")
	public String toLogin() {
		log.debug("转到登录页面!");
		return "web/login/login";
	}

	@RequestMapping(value = "/managerLogin", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String managerLogin(HttpServletRequest request, String loginName, String password) {
		if (managerService.login(request, loginName, password)) {
			return Define.RESULT_SUCCESS;
		}
		return Define.ERROR_PASSWORD;
	}

	@RequestMapping("/toIndex")
	public String toIndex() {
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
	@ResponseBody
	public String register(HttpServletRequest request, String userName, String tel, String email, String password, String code, Model model)
			throws Exception {
		if (!indexService.checkCodeByTel(tel, code)) {
			return Define.ERROR_CODE;
		}
		if (loginService.register(userName, tel, email, password)) {
			HttpSession session = HttpUtils.getSession(request);
			session.setAttribute("userName",userName);
			return Define.RESULT_SUCCESS;
		}
		else {
			return Define.ERROR_ALREADY_REGITSTER;
		}
	}

	@RequestMapping("/showResult")
	public String showResult(HttpServletRequest request,Model model)
			throws Exception {
		HttpSession session = HttpUtils.getSession(request);
		String userName = (String) session.getAttribute("userName");
		model.addAttribute("userName", userName);
		return "web/login/showResult";
	}


	@RequestMapping("/toReset")
	public String toReset(HttpServletRequest request) {
		return "web/login/reset";
	}

	@RequestMapping("/resetTel")
	@ResponseBody
	public String resetTel(HttpServletRequest request, String tel, String code, String password) {
		User user = userService.getUserByPhone(tel);
		if (!indexService.checkCodeByTel(tel, code)) {
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
		if (!indexService.checkCodeByEmail(email, code)) {
			return "error";
		} else {
			if (!loginService.resetPassword(user, password)) {
				return "error";
			}
		}
		return "success";
	}
}
