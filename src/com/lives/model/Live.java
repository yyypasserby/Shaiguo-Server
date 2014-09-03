/**
 * 
 */
package com.lives.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yyypasserby
 *
 */
@XmlRootElement
public class Live {
	private int liveId;
	private String livename;
	private String liveImageSrc;
	private String timeToCast;
	public Live(int id, String name, String imgSrc, String time) {
		this.liveId = id;
		this.livename = name;
		this.liveImageSrc = imgSrc;
		this.timeToCast = time;
	}
	
	
	/**
	 * @return the livename
	 */
	public String getLivename() {
		return livename;
	}
	/**
	 * @param livename the livename to set
	 */
	public void setLivename(String livename) {
		this.livename = livename;
	}
	/**
	 * @return the liveImageSrc
	 */
	public String getLiveImageSrc() {
		return liveImageSrc;
	}
	/**
	 * @param liveImageSrc the liveImageSrc to set
	 */
	public void setLiveImageSrc(String liveImageSrc) {
		this.liveImageSrc = liveImageSrc;
	}
	/**
	 * @return the timeToCast
	 */
	public String getTimeToCast() {
		return timeToCast;
	}
	/**
	 * @param timeToCast the timeToCast to set
	 */
	public void setTimeToCast(String timeToCast) {
		this.timeToCast = timeToCast;
	}


	/**
	 * @return the liveId
	 */
	public int getLiveId() {
		return liveId;
	}


	/**
	 * @param liveId the liveId to set
	 */
	public void setLiveId(int liveId) {
		this.liveId = liveId;
	}
}
