package com.fbm.finbrokermgmt.controllor;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fbm.finbrokermgmt.bean.FinBrokerService;
import com.fbm.finbrokermgmt.entity.BrokerDetails;

@Controller
public class FinBrokerController {

	@Autowired
	FinBrokerService service;
	
	/** Login and other common functions. */
	@RequestMapping(value = { "", "/login", "/index" })
	public String login(HttpServletRequest request) {
		return "index";
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
	
	@PostMapping("/showSummary")
	public String showSummary(HttpServletRequest request) {
		return null;
	}
	
	
	
	/** Admin - controlled functions. */
	@RequestMapping("/addBroker")
	@ResponseBody
	public BrokerDetails addBroker(@RequestParam(name="brokerName",required = true) String brokerName) {
		return service.addBroker(brokerName);
	}
	
	@RequestMapping("/deleteBroker")
	@ResponseBody
	public void deleteBroker(@RequestParam(name="brokerId",required = true) String brokerId){
		service.deleteBroker(brokerId);
	}
	
	@RequestMapping("/showBrokers")
	@ResponseBody
	public Collection<BrokerDetails> showAllBrokers(){
		return service.getAllBrokers();
	}
	
	
	
	
	/** Broker controlled functions. */
	@RequestMapping("/addUser")
	public BrokerDetails addUser(HttpServletRequest request) {
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

	

	
}
