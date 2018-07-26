package com.bluedigm.demo.api.sample.controller;

import com.bluedigm.demo.common.exception.ResourceNotFoundException;
import com.bluedigm.demo.common.message.MessageCode;
import com.bluedigm.demo.common.message.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping(value="/system/sample")
public class SamplePageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Messages messages;

	@GetMapping
	public String welcome(){
		logger.debug("debug  - SamplePageController - welcome");
		return "index";
	}

	@GetMapping(value = "/exceptionHtml")
	public String exceptionHtml(){
		logger.debug("debug  - SamplePageController - exceptionHtml");
		throw new ResourceNotFoundException(HttpStatus.NOT_FOUND
				, messages.getMessage(MessageCode.RESOURCE_NOT_FOUND, "Error Message Test!!") );
	}

	@GetMapping(value = "/exceptionHtml2")
	public String exceptionHtml2() throws Exception{
		logger.debug("debug  - SamplePageController - exceptionHtml2");
//		throw new Exception("Exception TEST");
		throw new SQLException("SQLException TEST");
	}
}
