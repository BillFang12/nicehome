package com.home.zx.nicehome.model;

import java.io.Serializable;

public class MessageModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String titleName;
	private String appName;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	@Override
	public int hashCode() {
		int titleHash=title.hashCode();
		int nameHash=titleName.hashCode();
		int appHash=appName.hashCode();
		return 31*titleHash*nameHash*appHash;
	}
	@Override
	public boolean equals(Object obj) {
		if(null==obj){
			return false;
		}
		if(obj instanceof MessageModel){
			MessageModel objs=(MessageModel) obj;
			if(objs.getAppName().equals(appName)
					&& titleName.equals(objs.getTitleName())
							&& title.equals(objs.getTitle())){
				return true;
			}
		}
		return super.equals(obj);
	}
	@Override
	public String toString() {
		
		return super.toString();
	}
	
	
	
	
}
