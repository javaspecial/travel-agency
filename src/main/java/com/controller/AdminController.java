package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminController {

	@RequestMapping(value = { "/", "panel" }, method = RequestMethod.GET)
	public ModelAndView getPage(HttpServletRequest request) {
		return new ModelAndView("admin");
	}
}
