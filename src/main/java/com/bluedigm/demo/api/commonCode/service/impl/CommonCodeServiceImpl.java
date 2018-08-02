/**
 * 
 */
package com.bluedigm.demo.api.commonCode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.demo.api.commonCode.dao.CommonCodeMapper;
import com.bluedigm.demo.api.commonCode.model.CommonGroupCodeModel;
import com.bluedigm.demo.api.commonCode.model.CommonCodeModel;
import com.bluedigm.demo.api.commonCode.service.CommonCodeService;

/**
 * @author Ayeon
 * @date 2018. 7. 25.
 *
 */
@Service
public class CommonCodeServiceImpl implements CommonCodeService {

	@Autowired
	private CommonCodeMapper commonCodeMapper;

	/* 
	 * @param commonGroupCodeModel
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#registerCommonGroupCode(com.bluedigm.demo.api.commonCode.model.CommonGroupCodeModel)
	 */
	@Override
	public int registerCommonGroupCode(CommonGroupCodeModel commonGroupCodeModel) {
		return commonCodeMapper.insertCommonGroupCode(commonGroupCodeModel);
	}

	/* 
	 * @param commonCodeModel
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#registerCommonCode(com.bluedigm.demo.api.commonCode.model.CommonCodeModel)
	 */
	@Override
	public int registerCommonCode(CommonCodeModel commonCodeModel) {
		return commonCodeMapper.insertCommonCode(commonCodeModel);
	}

	/* 
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#searchCommonGroupCodeList()
	 */
	@Override
	public List<CommonGroupCodeModel> searchCommonGroupCodeList() {
		return commonCodeMapper.selectCommonGroupCodeList();
	}

	/* 
	 * @param commonGroupCodeModel
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#searchCommonGroupCodeDetail(com.bluedigm.demo.api.commonCode.model.CommonGroupCodeModel)
	 */
	@Override
	public CommonGroupCodeModel searchCommonGroupCodeDetail(CommonGroupCodeModel commonGroupCodeModel) {
		return commonCodeMapper.selectCommonGroupCodeDetail(commonGroupCodeModel);
	}

	/* 
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#searchCommonCodeList()
	 */
	@Override
	public List<CommonCodeModel> searchCommonCodeList() {
		return commonCodeMapper.selectCommonCodeList();
	}

	/* 
	 * @param grpCdId
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#searchCommonCodeListByCdGrp(java.lang.String)
	 */
	@Override
	public List<CommonCodeModel> searchCommonCodeListByGrpCd(String grpCdId) {
		return commonCodeMapper.selectCommonCodeListByGrpCd(grpCdId);
	}

	/* 
	 * @param commonCodeModel
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#searchCommonCodeDetail(com.bluedigm.demo.api.commonCode.model.CommonCodeModel)
	 */
	@Override
	public CommonCodeModel searchCommonCodeDetail(CommonCodeModel commonCodeModel) {
		return commonCodeMapper.selectCommonCodeDetail(commonCodeModel);
	}

	/* 
	 * @param commonGroupCodeModel
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#modifyCommonGroupCode(com.bluedigm.demo.api.commonCode.model.CommonGroupCodeModel)
	 */
	@Override
	public int modifyCommonGroupCode(CommonGroupCodeModel commonGroupCodeModel) {
		return commonCodeMapper.updateCommonGroupCode(commonGroupCodeModel);
	}

	/* 
	 * @param commonCodeModel
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#modifyCommonCode(com.bluedigm.demo.api.commonCode.model.CommonCodeModel)
	 */
	@Override
	public int modifyCommonCode(CommonCodeModel commonCodeModel) {
		return commonCodeMapper.updateCommonCode(commonCodeModel);
	}

	/* 
	 * @param commonGroupCodeModel
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#removeCommonGroupCode(com.bluedigm.demo.api.commonCode.model.CommonGroupCodeModel)
	 */
	@Override
	public int deleteCommonGroupCode(List<String> grpCdIdList) {
		return commonCodeMapper.deleteCommonGroupCode(grpCdIdList);
	}

	/* 
	 * @param commonCodeModel
	 * @return
	 * @see com.bluedigm.demo.api.commonCode.service.CommonCodeService#removeCommonCode(com.bluedigm.demo.api.commonCode.model.CommonCodeModel)
	 */
	@Override
	public int removeCommonCode(CommonCodeModel commonCodeModel) {
		return commonCodeMapper.deleteCommonCode(commonCodeModel);
	}

}
