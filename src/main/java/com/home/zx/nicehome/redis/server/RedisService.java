package com.home.zx.nicehome.redis.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.home.zx.nicehome.redis.cache.CachePut;

@Service
public class RedisService {

	@Autowired
	private RedisTemplate<Object, Object> redisTemp;
	
	
	@CachePut
	public Object addUser(){
		
		
		return null;
	}
}
