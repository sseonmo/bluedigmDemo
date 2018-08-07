package com.bluedigm.demo.api.sample.controller;

import com.bluedigm.demo.api.sample.model.SampleModel;
import com.bluedigm.demo.api.sample.service.SampleService;
import com.bluedigm.demo.common.exception.ResourceNotFoundException;
import com.bluedigm.demo.common.message.MessageCode;
import com.bluedigm.demo.common.message.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * The type Sample rest controller.
 */
@RestController
@RequestMapping(value = "/api/sample")
public class SampleRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Messages messages;

	@Autowired
	private SampleService sampleService;

	/**
	 * Select sample list.
	 *
	 * @return the list
	 */
	@GetMapping
	public List<SampleModel> selectSample(){
		logger.info("SampleRestController - selectSample");
		return sampleService.selectSample();
	}

	/**
	 * Message test list.
	 *
	 * @return the list
	 */
	@GetMapping(value = "/messageTest")
	public List<String> messageTest() {
		logger.info("SampleRestController - messageTest");
		StringBuffer sbMessage = new StringBuffer();
		sbMessage.append(messages.getMessage(MessageCode.RESOURCE_NOT_FOUND, "Error Message Test!!"));
		sbMessage.append("<br>");
		sbMessage.append(messages.getMessage(MessageCode.MESSAGE_TEST, "Message Test!!"));

		return Arrays.asList(sbMessage.toString());
	}

	/**
	 * Exception json string.
	 *
	 * @return the string
	 */
	@GetMapping(value = "/exceptionJson")
	public String exceptionJson(){
		logger.debug("debug  - SampleRestController - exceptionJson");
		throw new ResourceNotFoundException(HttpStatus.NOT_FOUND
				, messages.getMessage(MessageCode.RESOURCE_NOT_FOUND, "Error Message Test!!") );
	}


	/**
	 * Headler test hash map.
	 *
	 * @return the hash map
	 */
	@PostMapping(value = "/booleanHeadlerTest")
	public List<SampleModel> headlerTest(){
		logger.debug("debug  - SampleRestController - booleanHeadlerTest");
		return sampleService.insertSample();
	}

	/**
	 * Headler test hash map.
	 *
	 * @return the hash map
	 */
	@PostMapping(value = "/xssFilter")
	public String xssFilter(@RequestParam String testText){
		logger.debug("debug  - SampleRestController - xssFilter - {}", testText);
		return testText;
	}

}
