package com.bluedigm.demo.api.sample.service;

import com.bluedigm.demo.api.sample.model.SampleModel;

import java.util.List;

/**
 * The interface Sample service.
 */
public interface SampleService {

	/**
	 * Select sample list.
	 *
	 * @return the list
	 */
	public List<SampleModel> selectSample();

	/**
	 * Insert sample list.
	 *
	 * @return the list
	 */
	public List<SampleModel> insertSample();
}
