package com.lives.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tag {
	private String tagName;
	private int tagId;
	
	public Tag() {}
	public Tag(int id, String name) {
		this.tagId = id;
		this.tagName = name;
	}
	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}
	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	/**
	 * @return the tagId
	 */
	public int getTagId() {
		return tagId;
	}
	/**
	 * @param tagId the tagId to set
	 */
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
}
