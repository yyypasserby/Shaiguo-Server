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
	private String thumbnail;
	private String timeToCast;
	
	public Live() {}
	
	public Live(int id, String name, String thumbnail, String time) {
		this.liveId = id;
		this.livename = name;
		this.thumbnail = thumbnail;
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

	/**
	 * @return the liveThumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}


	/**
	 * @param liveThumbnail the liveThumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
