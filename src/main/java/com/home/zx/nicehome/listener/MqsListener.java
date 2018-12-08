package com.home.zx.nicehome.listener;

import java.util.HashMap;
import java.util.Map;

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
				new Thread(new OperationRunnable(new HashMap<>())).start();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	
	static class OperationRunnable implements Runnable{
		ThreadLocal<Map> local=new ThreadLocal<Map>();
		public OperationRunnable(Map<String,Object> map){
			local.set(map);
		}
		
		@Override
		public void run() {
			long firstTime=System.currentTimeMillis();
			System.out.println("开始的时间是："+firstTime);
			Map<String,Object> map=local.get();
			try {
				System.out.println("线程启动了。。。。。。。。。。。。。。。。。。。。。。。");
				Thread.sleep(50000);
				System.out.println("线程结束了。。。。。。。。。。。。。。。。。。。。。。。");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("执行的时间是："+(System.currentTimeMillis()-firstTime));
		}
	}

}
