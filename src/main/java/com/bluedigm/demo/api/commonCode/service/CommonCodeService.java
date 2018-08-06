/**
 * 
 */
package com.bluedigm.demo.api.commonCode.service;

import java.util.List;

import com.bluedigm.demo.api.commonCode.model.CommonGroupCodeModel;
import com.bluedigm.demo.api.commonCode.model.CommonCodeModel;

/**
 * @author Ayeon
 * @date 2018. 7. 25.
 * CommonCode Service Interface
 */
public interface CommonCodeService {
	
	/**
	 * 공통 그룹 코드 등록
	 * @param commonGroupCodeModel
	 * @return int
	 */
	int registerCommonGroupCodeList(List<CommonGroupCodeModel> grpCdList);
	
	/**
	 * 공통 코드 등록
	 * @param commonCodeModel
	 * @return int
	 */
	int registerCommonCodeList(List<CommonCodeModel> cdList);
	
	/**
	 * 공통 코드 그룹 리스트 전체 조회
	 * @return List<CommonGroupCodeModel>
	 */
	List<CommonGroupCodeModel> searchCommonGroupCodeList();
	
	/**
	 * 공통 그룹 코드 상세 조회
	 * @param commonGroupCodeModel
	 * @return CommonGroupCodeModel
	 */
	CommonGroupCodeModel searchCommonGroupCodeDetail(CommonGroupCodeModel commonGroupCodeModel);
	
	/**
	 * 공통 코드 리스트 전체 조회
	 * @return List<CommonCodeModel>
	 */
	List<CommonCodeModel> searchCommonCodeList();
	
	/**
	 * 그룹 코드에 의한 공통 코드 리스트 조회
	 * @param grpCdId
	 * @return List<CommonGroupCodeModel>
	 */
	List<CommonCodeModel> searchCommonCodeListByGrpCd(String grpCdId);
	
	/**
	 * 공통 코드 상세 조회
	 * @param commonCodeModel
	 * @return CommonCodeModel
	 */
	CommonCodeModel searchCommonCodeDetail(CommonCodeModel commonCodeModel);
	
	/**
	 * 공통 그룹 코드 수정
	 * @param commonGroupCodeModel
	 * @return int
	 */
	int modifyCommonGroupCode(CommonGroupCodeModel commonGroupCodeModel);
	
	/**
	 * 공통 코드 수정
	 * @param commonCodeModel
	 * @return int
	 */
	int modifyCommonCode(CommonCodeModel commonCodeModel);
	
	/**
	 * 공통 그룹 코드 리스트 삭제
	 * @param List<String> 그룹 코드 아이디 리스트
	 * @return int
	 */
	int removeCommonGroupCodeList(List<String> grpCdIdList);
	
	/**
	 * 공통 그룹 코드 삭제
	 * @param commonGroupCodeModel
	 * @return int
	 */
	int deleteCommonGroupCode(CommonGroupCodeModel commonGroupCodeModel);
	
	/**
	 * 공통 코드 리스트 삭제
	 * @param List<String> 코드 아이디 리스트
	 * @return int
	 */
	int removeCommonCodeList(List<String> cdIdList);
	
	/**
	 * 공통 코드 삭제
	 * @param commonCodeModel
	 * @return int
	 */
	int deleteCommonCode(CommonCodeModel commonCodeModel);

}
