package com.home.zx.nicehome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RequestConfig {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public StringRedisTemplate redisTemplate(RedisConnectionFactory connectionFactory){
		return new StringRedisTemplate(connectionFactory);
	}
	
	@Bean
	public RedisConnectionFactory redisConnectionFactory(){
		JedisConnectionFactory factory=new JedisConnectionFactory();
		factory.setHostName("localhost");
		factory.setPort(6379);
		factory.setUsePool(true);
		return factory;
	}
}
