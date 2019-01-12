package com.home.zx.nicehome.redis.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.SortParameters.Order;
import org.springframework.data.redis.connection.SortParameters.Range;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.query.SortQuery;
import org.springframework.stereotype.Service;

@Service
public class RedisOperationService {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	

	public void saveDataToRedis(String key,String value){
		
	
		
		ListOperations<String, Object> lists=redisTemplate.opsForList();
		
		lists.getOperations().sort(new SortQuery<String>() {
			
			@Override
			public Boolean isAlphabetic() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Order getOrder() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Range getLimit() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<String> getGetPattern() {
				
				return null;
			}
			
			@Override
			public String getBy() {
				
				return null;
			}
		});
		
		
		//lists.leftPush(key, value);
		
	}
	
	
	public Object getDataToRedis(String key){
		
		
		return null;
	}
	
}
