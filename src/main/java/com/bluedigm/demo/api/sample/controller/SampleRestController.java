package com.bluedigm.demo.api.sample.controller;

import com.bluedigm.demo.api.sample.model.SampleModel;
import com.bluedigm.demo.api.sample.service.SampleService;
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
	private SampleService sampleService;

	@GetMapping
	public List<SampleModel> selectSample() throws Exception{
		logger.info("SampleRestController - selectSample");
		return sampleService.selectSample();
	}
}
