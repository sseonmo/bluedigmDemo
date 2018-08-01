/**
 * 
 */
package com.bluedigm.demo.api.commonCode.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<DynaTreeModel> searchCommonGroupCodeList() throws Exception{
		List<CommonGroupCodeModel> grpCdList = commonCodeService.searchCommonGroupCodeList();
		List<DynaTreeModel> treeList = new ArrayList<>();
		DynaTreeModel treeModel = null;
		
		for(CommonGroupCodeModel grpCdModel : grpCdList) {
			treeModel = new DynaTreeModel();
			treeModel.setKey(grpCdModel.getGrpCdId());
			treeModel.setTitle(grpCdModel.getGrpCdNm());
			treeModel.setFolder(true);
			treeModel.setLazy(true);
			treeModel.setOriginObject(grpCdModel);
			treeList.add(treeModel);
		}
		
//		Iterator<CommonGroupCodeModel> itr = grpCdList.iterator();
//		List<Map<String, Object>> tmpGrpCdList = new ArrayList<>();
//		
//		while(itr.hasNext()) {
//			CommonGroupCodeModel next = itr.next();
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("key", next.getGrpCd());
//			map.put("title", next.getGrpCdNm());
//			map.put("isFolder", true);
//			
//			List<CommonCodeModel> cdList = commonCodeService.searchCommonCodeListByGrpCd(next.getGrpCdId());
//			if(cdList.size() > 0) {
//				map.put("isLazy", true);
//				
//				Iterator<CommonCodeModel> itr2 = cdList.iterator();
//				List<Map<String, Object>> tmpCdList = new ArrayList<>();
//				
//				while(itr2.hasNext()) {
//					CommonCodeModel next2 = itr2.next();
//					Map<String, Object> map2 = new HashMap<String, Object>();
//					map2.put("key", next2.getCd());
//					map2.put("title", next2.getCdNm());
//					tmpCdList.add(map2);
//				}
//				map.put("children", tmpCdList);
//			}
//			tmpGrpCdList.add(map);
//		}
		
		return treeList;
	}
	
	@GetMapping("/searchCommonCodeListByGrpCd")
	public List<DynaTreeModel> searchCommonCodeListByGrpCd(@RequestParam String grpCdId) throws Exception{
		List<CommonCodeModel> cdList = commonCodeService.searchCommonCodeListByGrpCd(grpCdId);
		List<DynaTreeModel> treeList = new ArrayList<>();
		DynaTreeModel treeModel = null;
		
		for(CommonCodeModel cdModel : cdList) {
			treeModel = new DynaTreeModel();
			treeModel.setKey(cdModel.getCdId());
			treeModel.setTitle(cdModel.getCdNm());
			treeModel.setOriginObject(cdModel);
			treeList.add(treeModel);
		}
		
		return treeList;
	}
	
	@GetMapping("/searchCommonGroupCodeDetail")
	public DynaTreeModel searchCommonGroupCodeDetail(@RequestParam String grpCdId) throws Exception{
		CommonGroupCodeModel searchModel = new CommonGroupCodeModel();
		searchModel.setGrpCdId(grpCdId);
		CommonGroupCodeModel grpCd = commonCodeService.searchCommonGroupCodeDetail(searchModel);

		DynaTreeModel treeModel = new DynaTreeModel();
		treeModel.setKey(grpCd.getGrpCdId());
		treeModel.setTitle(grpCd.getGrpCdNm());
		treeModel.setOriginObject(grpCd);
		
		return treeModel;
	}
	
}
