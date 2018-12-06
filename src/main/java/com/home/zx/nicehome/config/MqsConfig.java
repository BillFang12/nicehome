package com.home.zx.nicehome.config;

import javax.jms.MessageListener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.home.zx.nicehome.listener.MqsListener;

@Configuration
public class MqsConfig {
	
	@Bean
	public DefaultMessageListenerContainer defaultMessageListenerContainer(){
		ActiveMQQueue quee=new ActiveMQQueue("beyondLiQueueTest");
		DefaultMessageListenerContainer container=new DefaultMessageListenerContainer();
		container.setConnectionFactory(activeMQConnectionFactory());
		container.setDestination(quee);
		container.setMessageListener(messageListener());
		container.setSessionTransacted(false);
		container.setConcurrency("10-15");
		return container;
	}
	

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory(){
		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory();
		factory.setBrokerURL("failover:(tcp://127.0.0.1:61616)?initialReconnectDelay=100");
		factory.setUseAsyncSend(false);
		factory.setDispatchAsync(true);
		return factory;
	}
	
	@Bean
	public MessageListener messageListener(){
		MqsListener listener=new MqsListener();
		return listener;
	}

	/*@Bean
	public CachingConnectionFactory cachingConnectionFactory(ConnectionFactory connectionFactory){
		CachingConnectionFactory cachingConnectionFactory=new CachingConnectionFactory(connectionFactory);
		return cachingConnectionFactory;
	}*/
	
	
}
