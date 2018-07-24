package com.bluedigm.demo.api.sample.service.impl;

import com.bluedigm.demo.api.sample.dao.SampleMapper;
import com.bluedigm.demo.api.sample.model.SampleModel;
import com.bluedigm.demo.api.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMapper sampleMapper;

	@Override
	public List<SampleModel> selectSample(){
		return sampleMapper.selectSample();
	}
}
