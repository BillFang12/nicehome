package com.home.zx.nicehome.redis.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisOperationService {
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	

}
