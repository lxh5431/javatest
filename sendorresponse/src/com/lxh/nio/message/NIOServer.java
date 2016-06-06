package com.lxh.nio.message;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NIOServer {
	/**
	 * @author lxh version 1.0
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int port = 8080;
		Selector selector = Selector.open();
		ServerSocketChannel aa = ServerSocketChannel.open();
		ServerSocket serverSoket = aa.socket();
		serverSoket.bind(new InetSocketAddress(port));
		System.out.println("the server listening on port:" + port);
		aa.configureBlocking(false);
		aa.register(selector, SelectionKey.OP_ACCEPT);
		while (true) {
			int nkeys = selector.select(1000);
			if (nkeys > 0) {
				for (SelectionKey key : selector.selectedKeys()) {
					if (key.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						SocketChannel sc = server.accept();
						if (sc == null) {
							continue;
						}
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);

					} else if (key.isReadable()) {
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						SocketChannel sc = (SocketChannel) key.channel();
						int readBytes = 0;
						String message = null;
						try {
							int req;
							try {
								while ((req = sc.read(buffer)) > 0) {
									readBytes += req;
								}
							} catch (Exception e) {
								readBytes = 0;
							} finally {
								buffer.flip();
							}

							if (readBytes > 0) {
								message = Charset.forName("UTF-8").decode(buffer).toString();
								buffer = null;
							}
						} finally {
							if (buffer != null)
								buffer.clear();
						}
						if (readBytes > 0) {
							System.out.println("message is received from client:" + message);
							if ("quit".equalsIgnoreCase(message.trim())) {
								sc.close();
								selector.close();
								System.out.println("Server has been shutdown!");
								System.exit(0);

							}
							String outMessage = "server response:" + message;
							sc.write(Charset.forName("UTF-8").encode(outMessage));
						}

					}
				}
				selector.selectedKeys().clear();
			}
		}
	}
}
