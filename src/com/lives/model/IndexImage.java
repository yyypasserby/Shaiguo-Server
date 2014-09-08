package com.lives.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IndexImage {
	private String imgSrc;
	private String caption;
	private String introduction;
	
	public IndexImage() {}
	
	public IndexImage(String imageSrc) {
		this.setImgSrc("images/" + imageSrc);
		this.caption = "Sleepy cat";
		this.introduction = "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.";
	}
	
	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}
	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}
	/**
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * @param introduction the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @return the imgSrc
	 */
	public String getImgSrc() {
		return imgSrc;
	}

	/**
	 * @param imgSrc the imgSrc to set
	 */
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
}
