package com.discount.utils;

public interface CommonConstants
{
	String BROWSER_PROP_KEY = "browser";
	String CONFIG_FILE 		= "config.properties";
	
	public interface BroswerType
	{
		String FIREFOX_BROSWER = "FIREFOX";
		String CHROME_BROSWER = "CHROME";
		String IE_BROSWER = "IE";
		String SAFARI_BROSWER = "SAFARI";
	}
	
	public interface RemoteSeleniumServerURL
	{
		String IE		 = "RemoteSeleniumServerURL_IE";     
		String CHROME 	 = "RemoteSeleniumServerURL_CHROME";
		String FIREFOX	 = "RemoteSeleniumServerURL_FIREFOX";
		String SAFARI 	 = "RemoteSeleniumServerURL_SAFARI";

	}
}