package com.home.zx.nicehome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestClient {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	public String invokeGet(String url){
		restTemplate.getForEntity(url,Object.class);
		return "";
	}

}
