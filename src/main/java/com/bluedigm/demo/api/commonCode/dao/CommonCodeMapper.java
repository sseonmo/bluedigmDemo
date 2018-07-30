/**
 * 
 */
package com.bluedigm.demo.api.commonCode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bluedigm.demo.api.commonCode.model.CommonGroupCodeModel;
import com.bluedigm.demo.api.commonCode.model.CommonCodeModel;

/**
 * @author Ayeon
 * CommonCode DAO Mapper
 */
@Mapper
@Repository
public interface CommonCodeMapper {
	
	/**
	 * 공통 그룹 코드 등록
	 * @param commonGroupCodeModel
	 * @return int
	 */
	int insertCommonGroupCode(CommonGroupCodeModel commonGroupCodeModel);
	
	/**
	 * 공통 코드 등록
	 * @param commonCodeModel
	 * @return int
	 */
	int insertCommonCode(CommonCodeModel commonCodeModel);
	
	/**
	 * 공통 코드 그룹 리스트 전체 조회
	 * @return List<CommonGroupCodeModel>
	 */
	List<CommonGroupCodeModel> selectCommonGroupCodeList();
	
	/**
	 * 공통 그룹 코드 상세 조회
	 * @param commonGroupCodeModel
	 * @return CommonGroupCodeModel
	 */
	CommonGroupCodeModel selectCommonGroupCodeDetail(CommonGroupCodeModel commonGroupCodeModel);
	
	/**
	 * 공통 코드 리스트 전체 조회
	 * @return List<CommonCodeModel>
	 */
	List<CommonCodeModel> selectCommonCodeList();
	
	/**
	 * 그룹 코드에 의한 공통 코드 리스트 조회
	 * @param grpCdId
	 * @return List<CommonGroupCodeModel>
	 */
	List<CommonCodeModel> selectCommonCodeListByGrpCd(String grpCdId);
	
	/**
	 * 공통 코드 상세 조회
	 * @param commonCodeModel
	 * @return CommonCodeModel
	 */
	CommonCodeModel selectCommonCodeDetail(CommonCodeModel commonCodeModel);
	
	/**
	 * 공통 그룹 코드 수정
	 * @param commonGroupCodeModel
	 * @return int
	 */
	int updateCommonGroupCode(CommonGroupCodeModel commonGroupCodeModel);
	
	/**
	 * 공통 코드 수정
	 * @param commonCodeModel
	 * @return int
	 */
	int updateCommonCode(CommonCodeModel commonCodeModel);
	
	/**
	 * 공통 그룹 코드 삭제
	 * @param commonGroupCodeModel
	 * @return int
	 */
	int deleteCommonGroupCode(CommonGroupCodeModel commonGroupCodeModel);
	
	/**
	 * 공통 코드 삭제
	 * @param commonCodeModel
	 * @return int
	 */
	int deleteCommonCode(CommonCodeModel commonCodeModel);
	
}
