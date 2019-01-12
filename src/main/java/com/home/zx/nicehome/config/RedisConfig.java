package com.home.zx.nicehome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RedisConfig {

	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<String, Object> template=new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		ObjectMapper mapper=new ObjectMapper();
		Jackson2JsonRedisSerializer<Object> redisSerializer=new Jackson2JsonRedisSerializer<>(Object.class);
		redisSerializer.setObjectMapper(mapper);
		template.setValueSerializer(redisSerializer);
		return template;
	}
	
	
	
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
		StringRedisTemplate template=new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}
}
