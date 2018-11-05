package com.home.zx.nicehome.redis.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.StringUtils;

import com.home.zx.nicehome.redis.cache.CachePut;

@Service
public class RedisService {

	@Autowired
	private RedisTemplate<Object, Object> redisTemp;
	
	@Autowired(required=true)
	private TransactionTemplate transcation;
	
	
	@CachePut
	public Object addUser(){
		
		
		return null;
	}
	
	public String sendOrder(){
		String result=transcation.execute(new TransactionCallback<String>() {
			@Override
			public String doInTransaction(TransactionStatus status) {
				return null;
			}
		});
		if(!StringUtils.isEmpty(result)){
			
		}
		return null;
	}
	
}
