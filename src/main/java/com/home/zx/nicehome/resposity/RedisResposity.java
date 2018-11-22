package com.home.zx.nicehome.resposity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.home.zx.nicehome.model.TickerModel;

@Component
public class RedisResposity {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public void loadUser(){
		//redisTemplate.sort(query);
		
		List<TickerModel> list=new ArrayList<TickerModel>();
		TickerModel model=new TickerModel();
		model.setKeyDate(new Date());
		
		
		redisTemplate.exec();
		//redisTemplate.expire("redisKey", new Date().getTime(), TimeUnit.HOURS);
	}

}
