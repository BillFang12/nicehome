package com.home.zx.nicehome.redis.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.home.zx.nicehome.model.TickerModel;
import com.home.zx.nicehome.redis.cache.CachePut;

@Service
public class RedisService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@CachePut
	public TickerModel addUser(){
		
		
		
		return null;
	}
	
	public String sendOrder(String url){
		//ResponseEntity<TickerModel> model=restTemplate.getForEntity(url, TickerModel.class);
		System.out.println("----------------子线程的开始了------"+System.currentTimeMillis());
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("----------------子线程的结束了------"+System.currentTimeMillis());
		return "success";
	}
	
}
