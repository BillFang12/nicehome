package com.home.zx.nicehome.resposity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisResposity {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public void loadUser(){
		redisTemplate.expire("", new Date().getTime(), TimeUnit.HOURS);
	}

}
