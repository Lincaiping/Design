package web.index.service;

import com.base.Define;
import com.base.HttpUtils;
import com.table.code.entity.Code;
import com.table.code.service.CodeService;
import com.table.limit.service.LimitService;
import com.table.user.entity.User;
import com.table.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.login.entity.PassType;

@Service
public class IndexService {
	@Autowired
	private LimitService limitService;

	@Autowired
	private CodeService codeService;

	@Autowired
	private UserService userService;

	public boolean setTelCode(String tel, String code) {
		try {
			User user = userService.getUserByPhone(tel);
			Code securityCode = new Code();
			if (null != user) {
				String userId = user.getId();
				securityCode.setUserId(userId);
			}
			String enableTime = HttpUtils.getTime();
			securityCode.setCode(code);
			securityCode.setTel(tel);
			securityCode.setType(Define.telPhone);
			securityCode.setEnableTime(enableTime);
			codeService.saveOrUpdate(securityCode);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean setEmailCode(String email, String code) {
		try {
			User user = userService.getUserByEmail(email);
			Code securityCode = new Code();
			if (null != user) {
				String userId = user.getId();
				securityCode.setUserId(userId);
			}
			String enableTime = HttpUtils.getTime();
			securityCode.setEnableTime(enableTime);
			securityCode.setCode(code);
			securityCode.setEmail(email);
			securityCode.setType(Define.telPhone);
			codeService.saveOrUpdate(securityCode);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean limitAble(HttpServletRequest request, Integer type) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		if(userId == null){
			return false;
		}
		Integer maxCount = PassType.getCount(type);
		int currentCount = limitService.getCurrentCount(userId, type);
		if (maxCount < currentCount) {
			limitService.disable(userId, type);
			return false;
		}
		return true;
	}

	public boolean checkCodeByTel(String tel, String code) {
		Code codeClass = codeService.getCodeByPhone(tel);
		return codeClass.getCode().equals(code);
	}

	public boolean resetCode(String userId, String code) {
		Code securityCode = codeService.getCodeById(userId);
		return securityCode.getCode().equals(code);
	}

	public boolean checkCode(HttpServletRequest request, String code) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		Code securityCode = codeService.getCodeById(userId);
		return Objects.equals(securityCode.getCode(), code);
	}
}
