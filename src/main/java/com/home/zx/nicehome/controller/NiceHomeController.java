package com.home.zx.nicehome.controller;

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
	
	
	
	
}
