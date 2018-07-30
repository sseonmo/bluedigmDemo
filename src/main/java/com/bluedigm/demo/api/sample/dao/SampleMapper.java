package com.bluedigm.demo.api.sample.dao;

import com.bluedigm.demo.api.sample.model.SampleModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Sample mapper.
 */
@Mapper
@Repository
public interface SampleMapper {

	/**
	 * Select sample list.
	 *
	 * @return the list
	 */
	List<SampleModel> selectSample();

	/**
	 * Insert sample.
	 *
	 * @param model the model
	 */
	void insertSample(SampleModel model);

}
