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
	private int attention;
	private int rating;
	
	public Live() {}
	
	public Live(int id, String name, String thumbnail, String time) {
		this.liveId = id;
		this.livename = name;
		this.thumbnail = thumbnail;
		this.timeToCast = time;
		this.attention = 1000;
		this.rating = 100;
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

	/**
	 * @return the attention
	 */
	public int getAttention() {
		return attention;
	}

	/**
	 * @param attention the attention to set
	 */
	public void setAttention(int attention) {
		this.attention = attention;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
}
