package tcpsocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket server;
	Socket socket;
	public static void main(String[] args){
		Server TempServer=new Server();
	}
	public Server(){
		try{
		server=new ServerSocket(1414);
		System.out.println("Socket监听服务已经启动：");
		System.out.println("正在等待客户端程序的请求....");
	
		socket=server.accept();
		System.out.println("客户端已经成功连接。");
		BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		out.println("来自监听服务器的问候：你好！");
		out.close();
		in.close();
		server.close();
		}catch(Exception e){
			System.out.print(e.toString());
		
		System.exit(1);}

}
}
