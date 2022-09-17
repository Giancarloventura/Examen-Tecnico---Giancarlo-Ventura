package com.spring.fullstack.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(scanBasePackages= {"com.spring.fullstack.test"}, exclude = {DataSourceAutoConfiguration.class})
public class SpringBooFullstacktApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringBooFullstacktApplication.class, args);
	}
	
}
