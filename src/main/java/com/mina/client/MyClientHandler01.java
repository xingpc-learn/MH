package com.mina.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author: XingPc
 * @版本: 1.0
 * @创建日期: 2019年9月23日 下午8:48:12
 * @ClassName MyClientHandler01
 * @类描述-Description: TODO
 */

public class MyClientHandler01 extends IoHandlerAdapter {

	private static final Logger log = LoggerFactory.getLogger(MyClientHandler01.class);

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		// 出现异常
		log.error("--------exception--------");
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("client端：" + session.getId() + " 关闭输入");
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		// 从服务器中接收到消息后的处理
		log.info("--------msg receive--------");
		log.info("Message:{}" + message.toString());
		System.out.println("client端接收信息：" + message.toString());
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		// 往服务器中发送消息
		log.info("--------msg sent--------");
		System.out.println("client端发送信息：" + message.toString());
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("client端与：" + session.getRemoteAddress().toString() + " 关闭连接");
		System.exit(0);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		// 当session被创建的时候调用
		log.info("--------session create--------");
		System.out.println("client端与：" + session.getRemoteAddress().toString() + " 建立连接");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("client端闲置连接：会话 " + session.getId() + " 被触发 " + session.getIdleCount(status) + " 次");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("client端打开连接");
	}

}
