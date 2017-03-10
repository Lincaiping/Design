package web.login.service;

import com.base.encrypt.aes.AES;
import com.table.user.entity.User;
import com.table.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录模块功能类
 *
 * @author gbq 2016年4月19日
 */
@Service
public class LoginService {
	@Autowired
	private UserService userService;

	/**
	 * 登录验证
	 *
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 * @author gbq 2016年4月19日
	 */
	public User userLogin(HttpServletRequest request, String userName,
						  String password, String token) {
		User user = userService.getUserByName(userName);
		if (user.getEnable() == 0) {
			return null;
		}
		try {
			String userPassword = AES.Decrypt(user.getPassword(),
					"1234567890123456");
			assert userPassword != null;
			if (userPassword.equals(password)) {
				HttpSession session = request.getSession();
				if (null == token || token.isEmpty()) {
					session.setAttribute("userId", user.getId());
				} else {
					session.setAttribute("mac", token);
					session.setAttribute("userId", user.getId());
					session.setMaxInactiveInterval(30 * 60);
				}
				return user;
			}
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean loginOut(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			session.setAttribute("userId", null);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public boolean register(String userName, String tel,String email, String password) {
		User user = new User();
		String safePassWord;
		try {
			safePassWord = AES.Encrypt(password, "1234567890123456");
			user.setPassword(safePassWord);
			user.setUserName(userName);
			user.setTel(tel);
			user.setEmail(email);
			userService.saveOrUpdate(user);
			return true;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	public boolean resetPassword(User user, String password) {
		try {
			String safePassWord = AES.Encrypt(password, "1234567890123456");
			user.setPassword(safePassWord);
			userService.saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
