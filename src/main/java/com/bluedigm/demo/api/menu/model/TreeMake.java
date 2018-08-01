package com.bluedigm.demo.api.menu.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TreeMake {
	
	public String makeTree(List<?> listview) {
        List<SelectedMenu> rootlist = new ArrayList<SelectedMenu>();
        
		for (int i = 0; i < listview.size(); i++) {            
			SelectedMenu mtDO = (SelectedMenu)listview.get(i);            
		    
			if ("0".equals(mtDO.getParent())) {
			    rootlist.add(mtDO);
			    continue;
			}
			
		for (int j = 0; j < listview.size(); j++) {
			 SelectedMenu ptDO = (SelectedMenu) listview.get(j);
			 
		     if (mtDO.getParent().equals(ptDO.getKey())) {
		         if (ptDO.getChildren() == null) {
		             ptDO.setChildren(new ArrayList<Object>() );
		         }
		         List<SelectedMenu> list = ptDO.getChildren();
		         list.add(mtDO);
		         ptDO.setIsFolder(true);
		         break;
		     }
		 }     
		 }

		ObjectMapper mapper = new ObjectMapper();
		String str = "";
	    try {
	        str = mapper.writeValueAsString(rootlist);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return str;
	}	
	
}
