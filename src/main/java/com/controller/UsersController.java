package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Location;
import com.model.Status;
import com.model.User;
import com.resources.UsersCookie;
import com.service.LocationService;
import com.service.StatusService;
import com.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	UsersService userServices;

	@Autowired
	LocationService locationService;

	@Autowired
	StatusService statusService;

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public ModelAndView getPage(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("index");
		if (StringUtils.isEmpty(UsersCookie.getInstance().getCookie(request))) {
			return view;
		}
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	@ExceptionHandler({ Exception.class })
	public @ResponseBody Map<String, Object> saveUserRegistration(User user) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())) {
				map.put("signUpMSG", "mandetory");
				return map;
			} else if (userServices.save(user)) {
				map.put("signUpMSG", "successfull");
				return map;
			} else {
				map.put("signUpMSG", "notCreated");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return map;
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	@ExceptionHandler({ Exception.class })
	public ModelAndView loginProcess(@RequestParam(value = "user_name", required = false) String userEmail,
			@RequestParam(value = "password", required = false) String password, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("home");
		try {
			if ("GET".equals(request.getMethod())) {
				if (StringUtils.isEmpty(UsersCookie.getInstance().getCookie(request))) {
					return new ModelAndView("index");
				}
				return mv;
			}
			if (userServices.validateUser(userEmail, password)) {
				mv.addObject("userId", userServices.getCurrentUserByEmail(userEmail));
				mv.addObject("userEmail", userEmail);
				UsersCookie.getInstance().setCookie(userEmail, response);
				return mv;
			} else {
				mv = new ModelAndView("index");
				mv.addObject("loginFailedMSG", "Email & password mismatch");
				return mv;
			}
		} catch (Exception e) {
			mv = new ModelAndView("exception");
			mv.addObject("exception", e.getMessage().toString());
			return mv;
		}
	}

	@ModelAttribute("allStatus")
	public List<Status> allStatus() {
		List<Status> listOfStatus = statusService.list();
		return listOfStatus;
	}

	@RequestMapping(value = "/postStatus", method = RequestMethod.POST)
	@ExceptionHandler({ Exception.class })
	public @ResponseBody Map<String, Object> postStatus(Status status) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (status != null) {
				statusService.save(status);
				map.put("status", "success");
			} else {
				map.put("status", "error");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return map;
	}

	@ModelAttribute("locations")
	public List<Location> getListOfLocations() {
		List<Location> listOfLocations = locationService.getListOfLocation();
		try {
			if (listOfLocations == null || listOfLocations.size() == 0) {
				String locationsName[] = { "Sylhet", "Bandarbon", "Khulna" };
				for (String name : locationsName) {
					Location location = new Location();
					location.setLocationName(name);
					locationService.save(location);
					listOfLocations.add(location);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return listOfLocations;
	}

	@RequestMapping(value = "/existEmail", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> emailExist(User users) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userServices.existEmail(users.getEmail())) {
			map.put("message", "exist");
			return map;
		} else {
			map.put("message", "accepted");
			return map;
		}
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSaved(User users) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userServices.saveOrUpdate(users)) {
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully.");
		}
		return map;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAll(User users) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> list = userServices.list();
		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found.");
			map.put("data", list);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found!");
		}
		return map;
	}

	@RequestMapping(value = "/deletePostStatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> deletePostStatus(@RequestParam("statusId") String statusId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isEmpty(statusId)) {
			map.put("status", "Can not deleted causes of id is empty");
		} else {
			Status status = statusService.getStatusById(Integer.valueOf(statusId));
			if (status != null && statusService.delete(status)) {
				map.put("status", "Deleted succesfully..");
			}
		}
		return map;
	}

	@RequestMapping(value = "/editPostStatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> editPostStatus(@RequestParam("statusId") String statusId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isEmpty(statusId)) {
			map.put("status", "Can not edit causes of id is empty");
		} else {
			Status status = statusService.getStatusById(Integer.valueOf(statusId));
			if (status != null && statusService.delete(status)) {
				map.put("status", "Deleted succesfully..");
			}
		}
		return map;
	}
}
