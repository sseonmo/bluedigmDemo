package com.bluedigm.demo.api.authorization.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluedigm.demo.api.authorization.service.ManagerService;

@RestController
@RequestMapping(value = "/api/authorization/manager")
public class ManagerRestController {

	/** 로그 출력. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** MenuService Autowired. */
	@Autowired
	private ManagerService managerService;

	/** 기본 경로. */ 
	private String thisUrl = "/api/authorization/manager";

  
}
