package com.bluedigm.demo.api.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/system/sample")
public class SamplePageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping
	public String welcome(){
		logger.debug("debug  - SamplePageController - welcome");
		logger.info("info - SamplePageController - welcome");
		return "index";
	}
	
}
