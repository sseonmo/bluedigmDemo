package com.bluedigm.demo.api.sample.controller;

import com.bluedigm.demo.api.sample.model.SampleModel;
import com.bluedigm.demo.api.sample.service.SampleService;
import com.bluedigm.demo.common.message.MessageCode;
import com.bluedigm.demo.common.message.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sample")
public class SampleRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Messages messages;

	@Autowired
	private SampleService sampleService;

	@GetMapping
	public List<SampleModel> selectSample(){
		logger.info("SampleRestController - selectSample");
		return sampleService.selectSample();
	}

	@GetMapping(value = "/messageTest")
	public String messageTest() {
		logger.info("SampleRestController - messageTest");
		StringBuffer sbMessage = new StringBuffer();
		sbMessage.append(messages.getMessage(MessageCode.RESOURCE_NOT_FOUND, "Error Message Test!!"));
		sbMessage.append("<br>");
		sbMessage.append(messages.getMessage(MessageCode.MESSAGE_TEST, "Message Test!!"));
		return sbMessage.toString();
	}
}
