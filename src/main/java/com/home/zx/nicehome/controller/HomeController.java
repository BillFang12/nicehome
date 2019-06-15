package com.home.zx.nicehome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	StringRedisTemplate redisTemplate;

	@RequestMapping("/article")
	public String scanArticle(){
		final String key="key1";
		boolean isExist=redisTemplate.hasKey(key);
		if(!isExist){
			addRedis(key, "update");
		}else{
			redisTemplate.opsForValue().set(key, "update");
			
		}
		return "success";
	}
	
	
	private String addRedis(String key, String value) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection cnn = (StringRedisConnection) connection;
				cnn.set(key, value);
				return "success";
			}
		});
	}
}
