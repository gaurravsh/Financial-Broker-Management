package com.fbm.finbrokermgmt.controllor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fbm.finbrokermgmt.bean.FinBrokerService;
import com.fbm.finbrokermgmt.entity.BrokerDetails;
import com.fbm.finbrokermgmt.entity.DealSummary;
import com.fbm.finbrokermgmt.entity.LendingDetails;
import com.fbm.finbrokermgmt.entity.UserDetails;
import com.fbm.finbrokermgmt.entity.UserIdAndName;
import com.fbm.finbrokermgmt.exception.FinBrokerException;

@Controller
public class FinBrokerController {

	@Autowired
	FinBrokerService brokerService;

	@InitBinder
	public void bindDate(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, false);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	
	/** Login and other common functions. */
	@GetMapping(value = { "", "/login", "/index" })
	public String loginPage() {
		//TODO : do the authentication with custom page.
		return "index";
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
		//TODO
		brokerService.deleteBroker(brokerId);
	}

	@GetMapping("/showAllBrokers")
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

	@RequestMapping("/showMyUsers")
	@ResponseBody
	public List<UserIdAndName> showUsers() throws FinBrokerException {
		return brokerService.showUsers();
	}

	@GetMapping("/addDeal")
	public String addDealpage() {
		return "addDeal";
	}

	@PostMapping("/addDeal")
	public LendingDetails addDealPost(@RequestParam(name = "borrowerId") String borrowerId,
			@RequestParam(name = "lenderId") String lenderId,
			@RequestParam(name="rate")double rate,
			@RequestParam(name="amount")long amount,
			@RequestParam(name="startDate") Date startDate,
			@RequestParam(name="endDate") Date endDate) throws FinBrokerException {
		//brokerService.addDeal(borrowerId, lenderId, rate, amount, startDate, endDate);
		return brokerService.addDeal(borrowerId, lenderId, rate, amount, startDate, endDate);
	}
	
	@RequestMapping("/showAllDeals")
	public ModelAndView showAllDeals() {
		List<DealSummary> allDeals= brokerService.getSummaryForBroker();
		ModelAndView view = new ModelAndView("showAllDetails");
		return view.addObject("allDeals", allDeals);
	}

}
