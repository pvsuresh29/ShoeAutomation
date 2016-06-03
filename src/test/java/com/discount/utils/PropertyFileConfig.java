package com.discount.utils;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
 
 
public class PropertyFileConfig {
	AbstractApplicationContext  context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    PropertyFileService service = (PropertyFileService) context.getBean("fileService");
    
		public String BrowserSetup(){
	         String Browser = service.browserInUse();
	         return Browser;
       
		}
		
		public String getEnvUrl(){
	         String envURL = service.URLInUse();
	         return envURL;
      
		}
		
	public void ContextClose(){
		
			context.close();
	}
     
}