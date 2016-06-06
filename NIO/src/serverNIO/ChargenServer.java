package serverNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ChargenServer {
	public static int DEFAULT_PORT = 19;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port;
		try{
			port=Integer.parseInt(args[1]);
			
		}
		catch(Exception ex){
			port=DEFAULT_PORT;
		}
		System.out.println("listening for connection on port:"+port);
		byte[] rotation=new byte[95*2];
		for(byte i=' ';i<='~';i++){
			rotation[i-' ']=i; 
			rotation[i+95-' ']=i;
			
		}
		ServerSocketChannel serverChannel;
		Selector selector;
		try{
			serverChannel=ServerSocketChannel.open();
			ServerSocket ss=serverChannel.socket();
			InetSocketAddress address=new InetSocketAddress(port);
			ss.bind(address);
		   serverChannel.configureBlocking(false);
		   selector=Selector.open();
		   serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		   
		}
		catch(IOException ex){
			ex.printStackTrace();
			return;
		}
		while(true){
			try{
				selector.select();
				
			}
			catch(IOException ex){
				ex.printStackTrace();
				break;
			}
			Set readyKeys=selector.selectedKeys();
			Iterator iterator=readyKeys.iterator();
			while(iterator.hasNext()){
				SelectionKey key=(SelectionKey)iterator.next();
				iterator.remove();
			try{
				if(key.isAcceptable()){
					ServerSocketChannel server=(ServerSocketChannel)key.channel();
				SocketChannel client=server.accept();
				System.out.println("Accepted connection from"+client);
				SelectionKey key2=client.register(selector, SelectionKey.OP_WRITE);
				ByteBuffer buffer=ByteBuffer.allocate(74);
				buffer.put(rotation,0,72);
				buffer.put((byte) '\r');
				buffer.put((byte) '\n');
				buffer.flip();
				key2.attach(buffer);
				}
				else if (key.isWritable()){
					SocketChannel client=(SocketChannel)key.channel();
					ByteBuffer buffer=(ByteBuffer)key.attachment();
					if(!buffer.hasRemaining()){
						buffer.rewind();
						int first=buffer.get();
						buffer.rewind();
						int postion=first-' '+1;
						buffer.put(rotation, postion, 72);
						buffer.put((byte) '\r');
						buffer.put((byte) '\n');
						buffer.flip();
						
					}
					client.write(buffer);
				}
			}
			catch(IOException ex){
				key.channel();
				try{
					key.channel().close();
					
				}catch(IOException cex){
					
				}
			}
			}
		}

	}

}
