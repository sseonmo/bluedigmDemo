package com.bluedigm.demo.api.menu.model;

import java.util.List;

/**
 * 선택 메뉴 Domain.
 *
 * <PRE>
 * 1. ClassName: SelectedMenu
 * 2. FileName : SelectedMenu.java
 * 3. Package  : com.skt.netruck.domain.authorization
 * 4. 작성자   : smyun@ntels.com
 * 5. 작성일   : 2014. 4. 8. 오후 5:02:49
 * 6. 변경이력
 *		이름  :		일자	: 변경내용
 *     ———————————————————————————————————
 *		smyun :	2014. 4. 8.	: 신규 개발.
 * </PRE>
 */

public class SelectedMenu{
	
	private String key;
    private String title;
    private String parent;
    private boolean isFolder;
    private List children;
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getParent() {
        return parent;
    }
    
    public void setParent(String parent) {
        this.parent = parent;
    }
    
    public List getChildren() {
        return children;
    }
    
    public void setChildren(List children) {
        this.children = children;
    }
    
    public boolean getIsFolder() {
        return isFolder;
    }
    
    public void setIsFolder(boolean isFolder) {
        this.isFolder = isFolder;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SelectedMenu [key=" + key + ", title=" + title + ", parent=" + parent + ", isFolder=" + isFolder
				+ ", children=" + children + "]";
	}
    

    
}
