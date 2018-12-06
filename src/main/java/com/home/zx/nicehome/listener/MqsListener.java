package com.home.zx.nicehome.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;

public class MqsListener implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		try {
			System.out.println("你收到了消息，这个消息是："+msg.getJMSMessageID());
			msg.getJMSDestination();
			System.out.println("你收的的數據是："+msg.getJMSTimestamp());
			System.out.println("我接收到的數據是："+msg.toString());
			
			if(msg instanceof ActiveMQTextMessage){
				ActiveMQTextMessage que=(ActiveMQTextMessage)msg;
				System.out.println("我的數據是："+que.getText());
			}
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
