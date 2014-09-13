package com.lives.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tag {
	private String tagName;
	private String tagNameEng;
	private int tagId;
	private String thumbnailSmall;
	private String thumbnailBig;
	private int livingNumber;
	private Integer tagAttention;
	
	public Tag() {}
	public Tag(int id, String name, String thumbnailSmall,String thumbnailBig, int attention) {
		this.tagId = id;
		this.tagName = name;
		this.thumbnailSmall = thumbnailSmall;
		this.thumbnailBig = thumbnailBig;
		this.livingNumber = 10;
		this.tagAttention = attention;
	}
	

	public Tag(int id, String name, String thumbnailSmall ,int attention) {
		this.tagId = id;
		this.tagName = name;
		this.thumbnailSmall = thumbnailSmall;
		this.livingNumber = 10;
		this.tagAttention = attention;
	}
	
	public Tag(int id, String name, String nameEng, int attention, int live,String thumbnailSmall,String thumbnailBig) {
		this.tagId = id;
		this.tagName = name;
		this.tagNameEng = nameEng;
		this.thumbnailSmall = thumbnailSmall;
		this.thumbnailBig = thumbnailBig;
		this.livingNumber = live;
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
	public Integer getTagAttention() {
		return tagAttention;
	}
	/**
	 * @param tagAttention the tagAttention to set
	 */
	public void setTagAttention(Integer tagAttention) {
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
	public String getThumbnailBig() {
		return thumbnailBig;
	}
	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnailBig(String thumbnail) {
		this.thumbnailBig = thumbnail;
	}
	
	public String getThumbnailSmall() {
		return thumbnailSmall;
	}
	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnailSmall(String thumbnail) {
		this.thumbnailSmall = thumbnail;
	}
	/**
	 * @return the tagNameEng
	 */
	public String getTagNameEng() {
		return tagNameEng;
	}
	/**
	 * @param tagNameEng the tagNameEng to set
	 */
	public void setTagNameEng(String tagNameEng) {
		this.tagNameEng = tagNameEng;
	}

}
