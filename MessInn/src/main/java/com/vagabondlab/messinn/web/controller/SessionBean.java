package com.vagabondlab.messinn.web.controller;

import java.io.Serializable;

import com.vagabondlab.messinn.util.ContextInfo;

public class SessionBean extends ContextInfo implements Serializable {
	private static final long serialVersionUID = 3558185367118348955L;
	
	private static final String SKIN_NAME = "skinName";
	private String skin;
	private String defaultSkin = "Default";
	private String imagesPath;
	private String cssPath;
	private String tagURL;

	public void changeTheme() {
		String skinName = this.getParameter(SKIN_NAME);
		if (skinName != null) {
			setSkin(skinName);
		}
	}

	public void prepareEmailURL() {
		System.out.println("action for open url");
	}

	public String getSkin() {
		if (skin == null) {
			skin = defaultSkin;
		}
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getImagesPath() {
		if (imagesPath == null) {
			imagesPath = "/resources/default/images";
		}
		return imagesPath;
	}

	public void setImagesPath(String imagesPath) {
		this.imagesPath = imagesPath;
	}

	public String getCssPath() {
		if (cssPath == null) {
			cssPath = "css";
		}
		return cssPath;
	}

	public void setCssPath(String cssPath) {
		this.cssPath = cssPath;
	}

	public String getTagURL() {
		return tagURL;
	}

	public void setTagURL(String tagURL) {
		this.tagURL = tagURL;
	}
}
