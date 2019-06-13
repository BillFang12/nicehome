package com.home.zx.nicehome.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.zx.nicehome.model.MessageModel;
import com.home.zx.nicehome.resposity.ActiveMqsResposity;

@RestController
public class NiceHomeController {
	
	@Autowired
	ActiveMqsResposity activeMqsResposity;

	@RequestMapping("/home")
	public String home(ModelMap map){
		return "index";
	}
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/send")
	public String sendMsg(){
		ObjectMapper mapper=new ObjectMapper();
		MessageModel modle=new MessageModel();
		modle.setAppName("you");
		modle.setTitle("我愛你");
		modle.setTitleName("陪伴你的左右");
		 Destination destination = new ActiveMQQueue("beyondLiQueueTest");
		 try {
			activeMqsResposity.send(destination, mapper.writeValueAsString(modle));
			
			activeMqsResposity.send(destination, modle);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@RequestMapping("/sendMessage")
	public Callable<String> sendMeessage(){
		Callable<String> taskCallable=new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(10000);
				return "success";
			}
		};
		FutureTask<String> task=new FutureTask<>(taskCallable);
		ExecutorService server=Executors.newCachedThreadPool();
		Future<Object> result=(Future<Object>) server.submit(task);
		try {
			result.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return taskCallable;
	}
	
	
}
