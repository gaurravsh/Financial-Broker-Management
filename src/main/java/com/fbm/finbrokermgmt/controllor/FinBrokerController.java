package com.fbm.finbrokermgmt.controllor;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinBrokerController {
	
	@PostMapping(value={"/login",""})
	public String login(HttpServletRequest request){
		
		return null;
	}
	
	@PostMapping("/addUser")
	public String addUser(HttpServletRequest request){
		Map<String, String[]> userMap=request.getParameterMap();
		
		return null;
	}
	
	@PostMapping("/addDeal")
	public String addDeal(HttpServletRequest request){
		return null;
	}
	
	@PostMapping("/showSummary")
	public String showSummary(HttpServletRequest request){
		return null;
	}
}
