package com.fbm.finbrokermgmt.controllor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fbm.finbrokermgmt.bean.FinBrokerService;

@Controller
public class FinBrokerController {

	@Autowired
	FinBrokerService service;

	@RequestMapping(value = { "", "/login", "/index" })
	public String login(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request) {
		Map<String, String[]> userMap = request.getParameterMap();
		service.addUser(userMap);
		return null;
	}

	@RequestMapping("/addDeal")
	public String addDeal(HttpServletRequest request) {
		Map<String, String[]> dealMap = request.getParameterMap();
		service.addDeal(dealMap);
		return null;
	}

	@PostMapping("/showSummary")
	public String showSummary(HttpServletRequest request) {
		return null;
	}

	@RequestMapping("/validate")
	public String validation(HttpServletRequest request) {
		String id = request.getParameter("userId");
		String password = request.getParameter("password");
		if (id.equals(password)) {
			return "success";
		} else {
			return "index";
		}

	}
}
