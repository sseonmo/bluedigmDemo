package com.bluedigm.demo.api.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluedigm.demo.api.manager.service.ManagerService;

@Controller
@RequestMapping(value = "/system/manager")
public class ManagerPageController {

	/** 로그 출력. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ManagerService managerService;
	

/*	@GetMapping
	//@RequestMapping(value = "menu", method = RequestMethod.POST)
	public String menu() {
		return "/authorization/menu";
	}*/
	
	@GetMapping(value = "/managerMain")
	public String managerList(ModelMap modelMap){
	   
	    return "authorization/manager/managerMain";
	}

		
}