/**
 * 
 */
package com.bluedigm.demo.api.commonCode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.demo.api.commonCode.dao.CommonCodeMapper;
import com.bluedigm.demo.api.commonCode.model.CommonCodeGroupModel;
import com.bluedigm.demo.api.commonCode.model.CommonCodeModel;
import com.bluedigm.demo.api.commonCode.service.CommonCodeService;

/**
 * @author Ayeon
 *
 */
@Service
public class CommonCodeServiceImpl implements CommonCodeService {

	@Autowired
	private CommonCodeMapper commonCodeMapper;
	
	@Override
	public List<CommonCodeGroupModel> selectCommonCodeGroupList() {
		return commonCodeMapper.selectCommonCodeGroupList();
	}
	
	@Override
	public List<CommonCodeModel> selectCommonCodeListByCdGrp(String grpCdId) {
		return commonCodeMapper.selectCommonCodeListByCdGrp(grpCdId);
	}

}
