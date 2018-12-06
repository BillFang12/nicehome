package com.home.zx.nicehome.resposity;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqsResposity {

	@Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
 
 
    /**
     * @param data
     * @desc 即时发送
     */
    public void send(Destination destination,String data) {
        this.jmsMessagingTemplate.convertAndSend(destination, data);
    }
	
}
