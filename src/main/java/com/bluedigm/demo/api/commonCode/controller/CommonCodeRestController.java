/**
 * 
 */
package com.bluedigm.demo.api.commonCode.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluedigm.demo.api.common.model.DynaTreeModel;
import com.bluedigm.demo.api.commonCode.model.CommonCodeModel;
import com.bluedigm.demo.api.commonCode.model.CommonGroupCodeModel;
import com.bluedigm.demo.api.commonCode.service.CommonCodeService;

/**
 * @author Ayeon
 * @date 2018. 7. 25.
 *
 */
@RestController
@RequestMapping(value = "/api/commonCode")
public class CommonCodeRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CommonCodeService commonCodeService;
	
	@GetMapping("/searchCommonGroupCodeList")
	public List<CommonGroupCodeModel> searchCommonGroupCodeList() throws Exception {
		return commonCodeService.searchCommonGroupCodeList();
	}
	
	@GetMapping("/searchCommonCodeListByGrpCd")
	public List<CommonCodeModel> searchCommonCodeListByGrpCd(@RequestParam String grpCdId) throws Exception {
//		List<CommonCodeModel> cdList = commonCodeService.searchCommonCodeListByGrpCd(grpCdId);
//		List<DynaTreeModel> treeList = new ArrayList<>();
//		DynaTreeModel treeModel = null;
//		
//		for(CommonCodeModel cdModel : cdList) {
//			treeModel = new DynaTreeModel();
//			treeModel.setKey(cdModel.getCdId());
//			treeModel.setTitle(cdModel.getCdNm());
//			treeModel.setOriginObject(cdModel);
//			treeList.add(treeModel);
//		}
//		
//		return treeList;
		return commonCodeService.searchCommonCodeListByGrpCd(grpCdId);
	}
	
	@GetMapping("/searchCommonGroupCodeDetail")
	public DynaTreeModel searchCommonGroupCodeDetail(@RequestParam String grpCdId) throws Exception {
		CommonGroupCodeModel searchModel = new CommonGroupCodeModel();
		searchModel.setGrpCdId(grpCdId);
		CommonGroupCodeModel grpCd = commonCodeService.searchCommonGroupCodeDetail(searchModel);

		DynaTreeModel treeModel = new DynaTreeModel();
		treeModel.setKey(grpCd.getGrpCdId());
		treeModel.setTitle(grpCd.getGrpCdNm());
		treeModel.setOriginObject(grpCd);
		
		return treeModel;
	}
	
	@PostMapping(value="/registerCommonGroupCodeList")
    public int registerCommonGroupCodeList(@RequestBody List<CommonGroupCodeModel> grpCdList) throws Exception {
        return commonCodeService.registerCommonGroupCodeList(grpCdList);
    }
	
	@PostMapping("/registerCommonCodeList")
    public int registerCommonCodeList(@RequestBody List<CommonCodeModel> cdList) {
        return commonCodeService.registerCommonCodeList(cdList);
    }
	
	@PostMapping("/modifyCommonGroupCode")
    public int modifyCommonGroupCode(@ModelAttribute CommonGroupCodeModel commonGroupCodeModel) {
        return commonCodeService.modifyCommonGroupCode(commonGroupCodeModel);
    }
	
	@PostMapping("/modifyCommonCode")
    public int modifyCommonCode(@ModelAttribute CommonCodeModel commonCodeModel) {
        return commonCodeService.modifyCommonCode(commonCodeModel);
    }
	
	@PostMapping("/removeCommonGroupCodeList")
    public int removeCommonGroupCodeList(@RequestParam("grpCdIdList") List<String> grpCdIdList) {
        return commonCodeService.removeCommonGroupCodeList(grpCdIdList);
    }
	
	@PostMapping("/removeCommonCodeList")
    public int removeCommonCodeList(@RequestParam("cdIdList") List<String> cdIdList) {
        return commonCodeService.removeCommonCodeList(cdIdList);
    }
	
}
