/**
 * 
 */
package com.bluedigm.demo.common.model;

import java.util.List;

/**
 * @author Ayeon
 * @date 2018. 7. 30.
 * front dynatree structure
 */
public class DynaTreeModel {
	
    public String title; // (required) Displayed name of the node (html is allowed here)
    public String key; // May be used with activate(); select(); find(); ...
    public boolean isFolder; // Use a folder icon. Also the node is expandable but not selectable.
    public boolean isLazy; // Call onLazyRead(); when the node is expanded for the first time to allow for delayed creation of children.
    public String tooltip; // Show this popup text.
    public String href; // Added to the generated <a> tag.
    public String icon; // Use a custom image (filename relative to tree.options.imagePath). 'null' for default icon; 'false' for no icon.
    public String addClass; // Class name added to the node's span tag.
    public boolean noLink; // Use <span> instead of <a> tag for this node
    public boolean activate; // Initial active status.
    public boolean focus; // Initial focused status.
    public boolean expand; // Initial expanded status.
    public boolean select; // Initial selected status.
    public boolean hideCheckbox; // Suppress checkbox display for this node.
    public boolean unselectable; // Prevent selection.
    public List<DynaTreeModel> children; // Array of child nodes.
    public Object originObject; // 트리 구조로 변환시키고자 하는 객체 (원본)
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public boolean isFolder() {
		return isFolder;
	}
	public void setFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}
	public boolean isLazy() {
		return isLazy;
	}
	public void setLazy(boolean isLazy) {
		this.isLazy = isLazy;
	}
	public String getTooltip() {
		return tooltip;
	}
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getAddClass() {
		return addClass;
	}
	public void setAddClass(String addClass) {
		this.addClass = addClass;
	}
	public boolean isNoLink() {
		return noLink;
	}
	public void setNoLink(boolean noLink) {
		this.noLink = noLink;
	}
	public boolean isActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	public boolean isFocus() {
		return focus;
	}
	public void setFocus(boolean focus) {
		this.focus = focus;
	}
	public boolean isExpand() {
		return expand;
	}
	public void setExpand(boolean expand) {
		this.expand = expand;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public boolean isHideCheckbox() {
		return hideCheckbox;
	}
	public void setHideCheckbox(boolean hideCheckbox) {
		this.hideCheckbox = hideCheckbox;
	}
	public boolean isUnselectable() {
		return unselectable;
	}
	public void setUnselectable(boolean unselectable) {
		this.unselectable = unselectable;
	}
	public List<DynaTreeModel> getChildren() {
		return children;
	}
	public void setChildren(List<DynaTreeModel> children) {
		this.children = children;
	}
	public Object getOriginObject() {
		return originObject;
	}
	public void setOriginObject(Object originObject) {
		this.originObject = originObject;
	}
	
}
