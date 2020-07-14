package com.zking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
 * Created by Administrator on 2017/5/5.
 */
/*
@SpringBootApplication
public class AppLication {
    public static void main(String[] args) {
        SpringApplication.run(AppLication.class, args);
    }

}*/

@SpringBootApplication            
public class AppLication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(AppLication.class);
	}
    public static void main(String[] args) {
        SpringApplication.run(AppLication.class, args);
    }

}














