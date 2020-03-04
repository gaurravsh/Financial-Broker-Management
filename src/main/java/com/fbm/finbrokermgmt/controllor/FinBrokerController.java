package com.fbm.finbrokermgmt.controllor;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fbm.finbrokermgmt.bean.FinBrokerService;
import com.fbm.finbrokermgmt.entity.BrokerDetails;
import com.fbm.finbrokermgmt.entity.UserDetails;
import com.fbm.finbrokermgmt.exception.FinBrokerException;

@Controller
public class FinBrokerController {

	@Autowired
	FinBrokerService brokerService;

	/** Login and other common functions. */
	@GetMapping(value = { "", "/login", "/index" })
	public String loginPage() {
		return "index";
	}

	@PostMapping("/showSummary")
	public String showSummary(HttpServletRequest request) {
		return null;
	}

	/** Admin - controlled functions. */
	@GetMapping("/addBroker")
	public String addBrokerPage() {
		return "addBroker";
	}

	@PostMapping("/addBroker")
	@ResponseBody
	public BrokerDetails addBroker(@RequestParam(name = "brokerName", required = true) String brokerName,
			@RequestParam(name = "brokerId", required = true) String brokerId) throws FinBrokerException {
		return brokerService.addBroker(brokerId, brokerName);
	}

	@RequestMapping("/deleteBroker")
	@ResponseBody
	public void deleteBroker(@RequestParam(name = "brokerId", required = true) String brokerId) {
		brokerService.deleteBroker(brokerId);
	}

	@GetMapping("/showBrokers")
	@ResponseBody
	public Collection<BrokerDetails> showAllBrokers() {
		return brokerService.getAllBrokers();
	}

	/** Broker controlled functions. */
	@GetMapping("/addUser")
	public String addUserPage() {
		return "addUser";
	}

	@PostMapping("/addUser")
	public UserDetails addUser(@RequestParam(name = "userName", required = true) String userName,
			@RequestParam(name = "userId", required = true) String userId) throws FinBrokerException {
		return brokerService.addUser(userId, userName);
	}

	@RequestMapping("/showUsers")
	@ResponseBody
	public List<UserDetails> showUsers() throws FinBrokerException {
		return brokerService.showUsers();
	}

	@RequestMapping("/getUser")
	@ResponseBody
	public List<UserDetails> getUser(@RequestParam(name = "userId", required = true) String userId) {
		return brokerService.getUser(userId);
	}

	@RequestMapping("/addDeal")
	public String addDeal(HttpServletRequest request) {
		Map<String, String[]> dealMap = request.getParameterMap();
		brokerService.addDeal(dealMap);
		return null;
	}

}
