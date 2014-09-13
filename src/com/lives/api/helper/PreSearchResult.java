/**
 * 
 */
package com.lives.api.helper;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yyypasserby
 *
 */
@XmlRootElement
public class PreSearchResult implements Comparable<PreSearchResult>{
	private int searchType;
	private String searchResult;
	
	public PreSearchResult() {}

	public PreSearchResult(int type, String rs) {
		this.searchType = type;
		this.searchResult = rs;
	}
	
	//searchType
	//0 : lives
	//1 : users
	//2 : caches
	/**
	 * @return the searchType
	 */
	public int getSearchType() {
		return searchType;
	}
	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	/**
	 * @return the searchResult
	 */
	public String getSearchResult() {
		return searchResult;
	}
	/**
	 * @param searchResult the searchResult to set
	 */
	public void setSearchResult(String searchResult) {
		this.searchResult = searchResult;
	}

	@Override
	public int compareTo(PreSearchResult pre) {
		// TODO Auto-generated method stub
		if(this.getSearchResult().compareTo(pre.getSearchResult())==0)
			pre.setEmpty();
		return 1;
	}
	
	public void setEmpty() {
		this.searchResult="";
	}
}
