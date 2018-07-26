/**
 * 
 */
package com.bluedigm.demo.api.commonCode.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluedigm.demo.api.commonCode.model.CommonCodeGroupModel;
import com.bluedigm.demo.api.commonCode.model.CommonCodeModel;
import com.bluedigm.demo.api.commonCode.service.CommonCodeService;

/**
 * @author Ayeon
 *
 */
@RestController
@RequestMapping(value = "/api/sample")
public class CommonCodeRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CommonCodeService commonCodeService;
	
	@GetMapping("/selectCommonCodeGroupList")
	public List<Map<String, Object>> selectCommonCode() throws Exception{
		List<CommonCodeGroupModel> grpCdList = commonCodeService.selectCommonCodeGroupList();
		Iterator<CommonCodeGroupModel> itr = grpCdList.iterator();
		List<Map<String, Object>> tmpGrpCdList = new ArrayList<>();
		
		while(itr.hasNext()) {
			CommonCodeGroupModel next = itr.next();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("key", next.getGrpCd());
			map.put("title", next.getGrpCdNm());
			map.put("isFolder", true);
			
			List<CommonCodeModel> cdList = commonCodeService.selectCommonCodeListByCdGrp(next.getGrpCdId());
			if(cdList.size() > 0) {
				map.put("isLazy", true);
				
				Iterator<CommonCodeModel> itr2 = cdList.iterator();
				List<Map<String, Object>> tmpCdList = new ArrayList<>();
				
				while(itr2.hasNext()) {
					CommonCodeModel next2 = itr2.next();
					Map<String, Object> map2 = new HashMap<String, Object>();
					map2.put("key", next2.getCd());
					map2.put("title", next2.getCdNm());
					tmpCdList.add(map2);
				}
				map.put("children", tmpCdList);
			}
			tmpGrpCdList.add(map);
		}
		
		return tmpGrpCdList;
	}
}
