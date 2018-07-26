/**
 * 
 */
package com.bluedigm.demo.api.commonCode.service;

import java.util.List;

import com.bluedigm.demo.api.commonCode.model.CommonCodeGroupModel;
import com.bluedigm.demo.api.commonCode.model.CommonCodeModel;

/**
 * @author Ayeon
 *
 */
public interface CommonCodeService {
	
	/**
	 * 공통 코드 그룹 리스트 조회
	 * @return List<CommonCodeGroupModel>
	 */
	public List<CommonCodeGroupModel> selectCommonCodeGroupList();
	
	
	/**
	 * 그룹 코드에 의한 공통 코드 리스트 조회
	 * @param grpCdId
	 * @return List<CommonCodeGroupModel>
	 */
	public List<CommonCodeModel> selectCommonCodeListByCdGrp(String grpCdId);

}
