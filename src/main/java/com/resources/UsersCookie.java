package com.resources;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

public class UsersCookie {
	private static UsersCookie usersCookie = null;

	public static UsersCookie getInstance() {
		if (usersCookie == null) {
			return new UsersCookie();
		}
		return usersCookie;
	}

	public void clearCookie(String username, HttpServletResponse response) {
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	public int getCookieMaxAge(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (!StringUtils.isEmpty(cookies)) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					return cookie.getMaxAge();
				}
			}
		}
		return 0;
	}

	public void setCookie(String username, HttpServletResponse response) {
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(60);
		response.addCookie(cookie);
	}

	public String getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (!StringUtils.isEmpty(cookies)) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
