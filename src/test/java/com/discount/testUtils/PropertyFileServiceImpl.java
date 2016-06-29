package com.discount.testUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Configuration
@ComponentScan(basePackages = { "com.discount.test.*" })
@PropertySource(value = "config.properties" )

@Service("fileService")
public class PropertyFileServiceImpl implements PropertyFileService {

	@Value("${browser}")
	private  String browserInUse;
	
	@Value("${envUrl}")
	private  String envUrl;
	
	@Value("${dtEnvUrl}")
	private  String dtEnvUrl;

	
		
		public String browserInUse(){
			System.out.println("Browser is " + browserInUse);
			return browserInUse;
		}
		
		public String URLInUse(){
			System.out.println("URL is " + envUrl);
			return envUrl;
		}
		
		public String DTURLInUse(){
			System.out.println("URL is " + dtEnvUrl);
			return dtEnvUrl;
		}
}