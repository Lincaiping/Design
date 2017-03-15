package web.index.controller;

import com.base.BaseController;
import com.base.HttpUtils;
import com.base.dao.PageBean;
import com.base.random.RandomSecret;
import com.table.advise.entity.Advise;
import com.table.advise.service.AdviseService;
import com.table.house.entity.House;
import com.table.house.service.HouseService;
import com.table.user.entity.User;
import com.table.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.index.service.IndexService;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
	@Autowired
	private UserService userService;

	@Autowired
	private AdviseService adviseService;

	@Autowired
	private IndexService indexService;

	@Autowired
	private HouseService houseService;

	private static int i = 0;

	@RequestMapping("/getCode")
	@ResponseBody
	public String getCode(HttpServletRequest request, String email, String tel) {
		Integer code = Integer.valueOf(RandomSecret.getNum());
		if (null == email) {
			if (indexService.setTelCode(tel,  String.valueOf(code))) {
				return "success";
			} else {
				return "error";
			}

		}
		if (null == tel) {
			if (indexService.setEmailCode(email, String.valueOf(code))) {
				return "success";
			} else {
				return "error";
			}
		}
		return "success";
	}

	@RequestMapping("/loginOut_manager")
	public String loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		log.debug("管理员退出登录！");
		session.setAttribute("managerName", null);
		return "manage/login";
	}

	@RequestMapping("/goManager")
	public String goList() {
		return "manage/login";
	}

	@RequestMapping("/404")
	public String go404() {
		return "404";
	}

	@RequestMapping("/toLogin")
	public String toLogin() {
		return "web/login/login";
	}

	@RequestMapping("/interfaces")
	public String interfaces() {
		return "index/interfaces";
	}

	@RequestMapping("/advise")
	public String advise(HttpServletRequest request, Model model) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		if (null != userId) {
			User user = userService.getUser(userId);
			model.addAttribute("userName", user.getUserName());
		}
		return "index/advise";
	}

	@RequestMapping("/addAdvise")
	@ResponseBody
	public String addAdvise(HttpServletRequest request, String userName, String tel, String content, String email) {
		Advise advise = new Advise();
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		if(null!=userId){
			advise.setUserId(userId);
		}
		advise.setDescrible(content);
		System.out.println(content);
		advise.setEmail(email);
		advise.setTel(tel);
		advise.setUsername(userName);
		try {
			adviseService.saveOrUpdate(advise);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping("/safeKnow")
	public String safeKnow() {
		return "index/safeKnow";
	}

	@RequestMapping("/toUpload")
	// @ResponseBody 返回json数据
	public String toUpload() {
		log.error("到了");
		return "test/upload/upload";
	}

	@RequestMapping("/toRend")
	// @ResponseBody 返回json数据
	public String toRend(Model model) {
		PageBean pageBean = new PageBean();
		pageBean.setPageNo(0);
		pageBean.setPageSize(20);
		List<House> houseList = houseService.getByPage(pageBean).getRows();
		List<String> imageList = new ArrayList<>();
		String firstImage;
		for (House house:houseList) {
			firstImage = house.getImage().split(",")[0];
			imageList.add(firstImage);
		}
		for (int i=0;i<imageList.size();i++){
			houseList.get(i).setImage(imageList.get(i));
		}
		model.addAttribute("houseList", houseList);
		return "web/index";
	}
}
