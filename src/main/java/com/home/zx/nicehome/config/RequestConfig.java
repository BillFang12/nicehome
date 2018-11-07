package com.home.zx.nicehome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RequestConfig {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
