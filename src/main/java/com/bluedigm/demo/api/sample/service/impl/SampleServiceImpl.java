package com.bluedigm.demo.api.sample.service.impl;

import com.bluedigm.demo.api.sample.dao.SampleMapper;
import com.bluedigm.demo.api.sample.model.SampleModel;
import com.bluedigm.demo.api.sample.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The type Sample service.
 */
@Service
public class SampleServiceImpl implements SampleService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SampleMapper sampleMapper;

	@Override
	public List<SampleModel> selectSample() {
		return sampleMapper.selectSample();
	}

	@Override
	public  List<SampleModel> insertSample() {

		SimpleDateFormat transFormat = new SimpleDateFormat("yyMMddHHmmss");
		SampleModel model = new SampleModel(String.format("admin_%s", transFormat.format(new Date())), "seonmo", "1111", "mo3509@gmail.com", "111", true);
		sampleMapper.insertSample(model);
		return selectSample();
	}
}
