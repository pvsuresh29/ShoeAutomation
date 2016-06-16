package com.discount.utils;

public class EnvUrl {
	
	PropertyFileConfig propCtx ;
	String envUrl;
	
	public String getEnvUrl(){
		
		propCtx = new PropertyFileConfig();
		envUrl = propCtx.getEnvUrl();
		return envUrl;
		
	}
	

}
