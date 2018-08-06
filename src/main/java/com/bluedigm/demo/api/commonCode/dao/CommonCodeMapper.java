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
 * @date 2018. 7. 25.
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
	int insertCommonGroupCodeList(List<CommonGroupCodeModel> grpCdList);
	
	/**
	 * 공통 코드 등록
	 * @param commonCodeModel
	 * @return int
	 */
	int insertCommonCodeList(List<CommonCodeModel> cdList);
	
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
	 * 공통 그룹 코드 리스트 삭제 여부 수정
	 * @param List<String> 그룹 코드 아이디 리스트
	 * @return int
	 */
	int updateDelYnYCommonGroupCodeList(List<String> grpCdIdList);
	
	/**
	 * 공통 그룹 코드 삭제 여부 수정
	 * @param commonGroupCodeModel
	 * @return int
	 */
	int updateDelYnYCommonGroupCode(CommonGroupCodeModel commonGroupCodeModel);
	
	/**
	 * 공통 코드 리스트 삭제 여부 수정
	 * @param List<String> 코드 아이디 리스트
	 * @return int
	 */
	int updateDelYnYCommonCodeList(List<String> cdIdList);
	
	/**
	 * 공통 코드 삭제 여부 수정
	 * @param commonCodeModel
	 * @return int
	 */
	int updateDelYnYCommonCode(CommonCodeModel commonCodeModel);
	
	/**
	 * 공통 그룹 코드 삭제
	 * @param commonCodeModel
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
