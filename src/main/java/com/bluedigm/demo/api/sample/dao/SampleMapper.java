package com.bluedigm.demo.api.sample.dao;

import com.bluedigm.demo.api.sample.model.SampleModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SampleMapper {

	List<SampleModel> selectSample();
}
