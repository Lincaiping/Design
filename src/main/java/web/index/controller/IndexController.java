package web.index.controller;

import com.base.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
	@RequestMapping("/loginOut_manager")
	public String loginOut(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		log.debug("管理员退出登录！");
		session.setAttribute("managerName", null);
		return "manage/login";
	}

	@RequestMapping("/goManager")
	public String goList(HttpServletRequest request) {
		return "manage/login";
	}

	@RequestMapping("/404")
	public String go404(HttpServletRequest request) {
		return "404";
	}

	@RequestMapping("/interfaces")
	public String interfaces(HttpServletRequest request) {
		return "index/interfaces";
	}

	@RequestMapping("/safeKnow")
	public String safeKnow(HttpServletRequest request) {
		return "index/safeKnow";
	}

	@RequestMapping("/toUpload")
	// @ResponseBody 返回json数据
	public String toUpload() {
		log.error("到了");
		return "test/upload/upload";
	}
}
