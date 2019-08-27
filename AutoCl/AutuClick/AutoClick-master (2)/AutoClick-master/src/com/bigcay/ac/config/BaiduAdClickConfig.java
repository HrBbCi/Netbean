package com.bigcay.ac.config;

public class BaiduAdClickConfig {

	private int maxThreadNumber; 
	
	private int proxyExtractNumber; 
	
	private String proxyExtractUrl;
	
	private String searchKeyword;
	
	private String[] targetLinkPartialTexts;

	public int getMaxThreadNumber() {
		return maxThreadNumber;
	}

	public void setMaxThreadNumber(int maxThreadNumber) {
		this.maxThreadNumber = maxThreadNumber;
	}

	public int getProxyExtractNumber() {
		return proxyExtractNumber;
	}

	public void setProxyExtractNumber(int proxyExtractNumber) {
		this.proxyExtractNumber = proxyExtractNumber;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getProxyExtractUrl() {
		return proxyExtractUrl;
	}

	public void setProxyExtractUrl(String proxyExtractUrl) {
		this.proxyExtractUrl = proxyExtractUrl;
	}

	public String[] getTargetLinkPartialTexts() {
		return targetLinkPartialTexts;
	}

	public void setTargetLinkPartialTexts(String[] targetLinkPartialTexts) {
		this.targetLinkPartialTexts = targetLinkPartialTexts;
	}

}
