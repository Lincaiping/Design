package com.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpUtils {
	public static HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}

	public static String getTime() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdFormatter.format(nowTime);
	}
}
