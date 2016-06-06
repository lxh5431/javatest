package com.lxh.nio.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NioClient {
	/**
	 * @author lxh version 1.0
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		int port=8080;
		SocketChannel socketchannel=SocketChannel.open();
		socketchannel.configureBlocking(false);
		SocketAddress socketaddress=new InetSocketAddress("localhost", port);
		socketchannel.connect(socketaddress);
		Selector selector=Selector.open();
		socketchannel.register(selector, SelectionKey.OP_CONNECT);
		BufferedReader systemIn=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			if(socketchannel.isConnected()){
				 String command=systemIn.readLine();  
	                socketchannel.write(Charset.forName("UTF-8").encode(command));  
	                  
	                if(command==null||"quit".equalsIgnoreCase(command.trim())){  
	                    systemIn.close();  
	                    socketchannel.close();  
	                    selector.close();  
	                    System.out.println("Client quit !");  
	                    System.exit(0); 
				
			}
		}
			int nKeys=selector.select(1000);  
            if(nKeys>0){  
                for(SelectionKey key:selector.selectedKeys()){  
                    if(key.isConnectable()){  
                        SocketChannel sc=(SocketChannel) key.channel();  
                        sc.configureBlocking(false);  
                        sc.register(selector, SelectionKey.OP_READ);  
                        sc.finishConnect();  
                    }else if(key.isReadable()){  
                        ByteBuffer buffer=ByteBuffer.allocate(1024);  
                        SocketChannel sc=(SocketChannel) key.channel();  
                        int readBytes=0;  
                        try{  
                            int req=0;  
                            try{  
                                while((req=sc.read(buffer))>0){  
                                    readBytes+=req;  
                                }  
                            }finally{  
                                buffer.flip();  
                            }  
                            if (readBytes > 0) {     
                                System.out.println(Charset.forName("UTF-8")     
                                        .decode(buffer).toString());     
                                buffer = null;     
                            }     
  
                        }finally {     
                            if (buffer != null) {     
                                buffer.clear();     
                            }  
                        }  
                    }  
                }  
                    selector.selectedKeys().clear();     
            }  
        }  
    }  
  

}
