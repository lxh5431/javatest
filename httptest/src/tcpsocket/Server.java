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
		System.out.println("Socket���������Ѿ�������");
		System.out.println("���ڵȴ��ͻ��˳��������....");
	
		socket=server.accept();
		System.out.println("�ͻ����Ѿ��ɹ����ӡ�");
		BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		out.println("���Լ������������ʺ���ã�");
		out.close();
		in.close();
		server.close();
		}catch(Exception e){
			System.out.print(e.toString());
		
		System.exit(1);}

}
}
