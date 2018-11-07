package com.home.zx.nicehome.redis;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.zx.nicehome.redis.server.RedisService;

@RestController
public class RedisController {
	
	@Autowired
	private RedisService service;
	
	@RequestMapping(value="/ticker")
	public Callable<String> getTicker(){
		String url="http://127.0.0.1:8081/api/getData";
		long startTime=System.currentTimeMillis();
		System.out.println("----------线程开始请求------------------");
		Callable<String> able=new Callable<String>() {
			@Override
			public String call() throws Exception {
				String result=service.sendOrder(url);
				return result;
			}
		};
		System.out.println("----------线程结束--------------花费的时间"+Long.toString(System.currentTimeMillis()-startTime));
		return able;
	}

}
