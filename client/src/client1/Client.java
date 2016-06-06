package client1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args){
		try{
			if(args.length!=1)
			{
				System.out.println("格式:java client serverName");
				return;
			}
			String SvrName=args[0];
			@SuppressWarnings("unused")
			Thread ListenThread=null;
			Socket connection;
			String KeyIn="";
			connection=new Socket(InetAddress.getByName(SvrName),1415);
			BufferedReader SvrIn=new BufferedReader(new InputStreamReader(connection.getInputStream()));
			PrintWriter SvrOut=new PrintWriter(connection.getOutputStream(),true);
			System.out.print("\n");
			String info=SvrIn.readLine();
			if(info!=null)
			{
				System.out.println(info+"\n");
				BufferedReader KeyBoard=new BufferedReader(new InputStreamReader(System.in));
				while(true)
				{
					System.out.println("请输入>");
					KeyIn=KeyBoard.readLine();
					SvrOut.println(KeyIn);
					if(KeyIn.length()<4)
					{
						continue;
					}
					if(KeyIn.equals("exit"))
					{
						break;
					}
					else if(KeyIn.substring(0,4).equals("lgn:"))
					{
						info=SvrIn.readLine();
						if(info!=null)
						
					{
						System.out.println(info+"\n");
						
						}
						}
					else if(KeyIn.substring(0, 4).equals("list"))
					{
						info=SvrIn.readLine();
						if(info!=null)
						{
							System.out.println(info+"\n");
						}
					}
				}
				connection.close();
			}
		}
			catch(Exception e)
			{
				System.out.println("\n系统信息：访问异常！");
			}
		}

}

