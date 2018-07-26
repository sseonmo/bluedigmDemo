/**
 * 
 */
package com.bluedigm.demo.api.commonCode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bluedigm.demo.api.commonCode.model.CommonCodeGroupModel;
import com.bluedigm.demo.api.commonCode.model.CommonCodeModel;

/**
 * @author Ayeon
 *
 */
@Mapper
@Repository
public interface CommonCodeMapper {
	
	/**
	 * 공통 코드 그룹 리스트 조회
	 * @return List<CommonCodeGroupModel>
	 */
	List<CommonCodeGroupModel> selectCommonCodeGroupList();
	
	
	/**
	 * 그룹 코드에 의한 공통 코드 리스트 조회
	 * @param grpCdId
	 * @return List<CommonCodeGroupModel>
	 */
	List<CommonCodeModel> selectCommonCodeListByCdGrp(String grpCdId);
}
