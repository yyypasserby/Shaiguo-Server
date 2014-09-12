package com.lives.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tag {
	private String tagName;
	private int tagId;
	private String thumbnail;
	private int livingNumber;
	private int tagAttention;
	
	public Tag() {}
	public Tag(int id, String name, String thumbnail, int attention) {
		this.tagId = id;
		this.tagName = name;
		this.thumbnail = thumbnail;
		this.livingNumber = 10;
		this.tagAttention = attention;
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
	/**
	 * @return the tagAttention
	 */
	public int getTagAttention() {
		return tagAttention;
	}
	/**
	 * @param tagAttention the tagAttention to set
	 */
	public void setTagAttention(int tagAttention) {
		this.tagAttention = tagAttention;
	}
	/**
	 * @return the livingNumber
	 */
	public int getLivingNumber() {
		return livingNumber;
	}
	/**
	 * @param livingNumber the livingNumber to set
	 */
	public void setLivingNumber(int livingNumber) {
		this.livingNumber = livingNumber;
	}
	/**
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}
	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
