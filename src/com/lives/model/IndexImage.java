package com.lives.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IndexImage {
	private String imageSrc;
	private String caption;
	private String introduction;
	
	public IndexImage(String imageSrc) {
		this.imageSrc = "images/" + imageSrc;
		this.caption = "Sleepy cat";
		this.introduction = "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.";
	}
	/**
	 * @return the imageSrc
	 */
	public String getImageSrc() {
		return imageSrc;
	}
	/**
	 * @param imageSrc the imageSrc to set
	 */
	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
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
}
