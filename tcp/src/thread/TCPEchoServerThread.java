package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class TCPEchoServerThread {
	public static void main(String[] args) throws IOException{
		if(args.length!=1){
			throw new IllegalArgumentException("Parameter(s):<port>");
		}
		int echoServPort=Integer.parseInt(args[0]);
		ServerSocket servSock=new ServerSocket(echoServPort);
		Logger logger=Logger.getLogger("practical");
		while(true){
			Socket clntsock=servSock.accept();
			Thread thread=new Thread(new EchoProtocol(clntsock,logger));
			thread.start();
			logger.info("Create and start Thread"+thread.getName());
		}
	}

}
