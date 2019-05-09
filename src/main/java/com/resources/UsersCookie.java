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

	public void setCookie(String username, HttpServletResponse response) {
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(60 * 30);
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
