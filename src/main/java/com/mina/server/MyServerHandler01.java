package com.mina.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author: XingPc
 * @版本: 1.0
 * @创建日期: 2019年9月23日 下午8:45:34
 * @ClassName MyServerHandler01
 * @类描述-Description: TODO
 */

public class MyServerHandler01 extends IoHandlerAdapter {

	private final static Logger logger = LoggerFactory.getLogger(MyServerHandler01.class);

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("捕获异常");
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		System.out.println("server端：" + session.getId() + " 关闭输入");
	}

	/**
	 * 当客户端发送的消息到达时
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String clientMessage = (String) message;
		logger.info("接收报文:" + clientMessage);
		// 解析报文存在map中

		// 执行业务逻辑，返回数据到map

		// 组装返回报文
		logger.info("返回报文:");
		session.write("\n\r");

	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("server端发送信息:" + message.toString());
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("server端IP：" + session.getRemoteAddress().toString() + " 关闭连接");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("server端IP：" + session.getRemoteAddress().toString() + " 创建连接");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("server端闲置连接：会话 " + session.getId() + " 被触发 " + session.getIdleCount(status) + " 次");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("server端打开连接");
	}

}
