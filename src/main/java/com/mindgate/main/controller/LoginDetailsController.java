package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.pojo.LoginDetails;
import com.mindgate.main.service.LoginDetailsServiceInterface;

@RestController
@RequestMapping("logindetails")
@CrossOrigin(origins = "*")
public class LoginDetailsController {
	@Autowired
	private LoginDetailsServiceInterface loginDetailsService;
	
	@RequestMapping(value = "userlogin", method = RequestMethod.POST)
	public @ResponseBody LoginDetails userLogin(@RequestBody LoginDetails loginDetails) {
		return loginDetailsService.userLogin(loginDetails);
	}
//
	@RequestMapping(value = "login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody boolean addLoginDetails(@RequestBody LoginDetails loginDetails) {
		System.out.println(loginDetails);

		return loginDetailsService.addLoginDetails(loginDetails);
	}
//
//	@RequestMapping(value = "login", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
//	public @ResponseBody boolean updateLoginDetails(@RequestBody LoginDetails loginDetails) {
//		return loginDetailsService.updateLoginDetails(loginDetails);
//	}
//
//	@RequestMapping(value = "login/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
//	public @ResponseBody boolean deleteLoginDetailsByID(@PathVariable("id") int loginId) {
//		return loginDetailsService.deleteLoginDetailsById(loginId);
//	}

	@RequestMapping(value = "login/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public @ResponseBody LoginDetails getLoginDetailsById(@PathVariable("id") int loginId) {

		System.out.println("in Login service Byid");
		return loginDetailsService.getLoginDetailsById(loginId);

	}

	@RequestMapping(value = "login", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<LoginDetails> getProducts() {
		return loginDetailsService.getAllLoginDetails();
	}

}
