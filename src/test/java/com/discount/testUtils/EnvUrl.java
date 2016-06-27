package com.discount.testUtils;

public class EnvUrl {
	
	PropertyFileConfig propCtx ;
	String envUrl;
	String dtEnvUrl;
	public String getEnvUrl(){
		
		propCtx = new PropertyFileConfig();
		envUrl = propCtx.getEnvUrl();
		return envUrl;
		
	}
	
public String getDTEnvUrl(){
		
		propCtx = new PropertyFileConfig();
		dtEnvUrl = propCtx.getDTEnvUrl();
		return dtEnvUrl;
		
	}
	

}
