package com.home.zx.nicehome.redis.server;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.home.zx.nicehome.model.TickerModel;
import com.home.zx.nicehome.redis.cache.CachePut;

@Service
public class RedisService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@CachePut
	public TickerModel addUser(){
		
		
		
		return null;
	}
	
	public String sendOrder(String url){
		//ResponseEntity<TickerModel> model=restTemplate.getForEntity(url, TickerModel.class);
		long startTime=System.currentTimeMillis();
		System.out.println("----------------子线程的开始了------"+System.currentTimeMillis());
		
		
		Callable<String> queryUserInfo=new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("----------queryUserInfo------子线程的开始了------"+System.currentTimeMillis());
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("----------queryUserInfo------子线程的结束了------"+System.currentTimeMillis());
				return "queryUserInfo";
			}
		};
		
		Callable<String> getUserInfo=new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("----------getUserInfo------子线程的开始了------"+System.currentTimeMillis());
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("----------getUserInfo------子线程的结束了------"+System.currentTimeMillis());
				return "getUserInfo";
			}
		};
		
		
		FutureTask<String> taskF=new FutureTask<>(queryUserInfo);
		FutureTask<String> taskS=new FutureTask<>(getUserInfo);
		
		new Thread(taskF).start();
		new Thread(taskS).start();
		
		try {
			taskF.get();
			taskS.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("----------------子线程的结束了------"+(System.currentTimeMillis()-startTime));
		return "success";
	}
	
}
