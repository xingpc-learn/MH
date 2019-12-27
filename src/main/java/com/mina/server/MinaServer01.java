package com.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 *
 * @author: XingPc
 * @版本: 1.0
 * @创建日期: 2019年9月23日 下午8:45:06
 * @ClassName MinaServer01
 * @类描述-Description: TODO
 */

public class MinaServer01 {

	// 设定服务器端口号
	private static final int PORT = 9000;

	public static void main(String[] args) throws IOException {
		// 创建服务监听器，6是IoProcessor的线程数
		IoAcceptor acceptor = new NioSocketAcceptor(6);
		// 增加日志过滤器
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		// 增加编码过滤器，统一编码UTF-8
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("utf-8"))));
		// 设置服务端逻辑处理器
		acceptor.setHandler(new MyServerHandler01());
		// 设置读缓存大小
		acceptor.getSessionConfig().setReadBufferSize(2048);
		// 设置指定类型的空闲时间，空闲时间超过这个值将触发sessionIdle方法
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		// 绑定端口
		acceptor.bind(new InetSocketAddress(PORT));

	}

}
