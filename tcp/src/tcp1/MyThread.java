package tcp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyThread extends Thread{
	private MyEvent CallMain;
	private Socket TmpSocket;
	public MyThread(Socket socket,MyEvent e){
		TmpSocket=socket;
		CallMain=e;
	}
	public void run(){
		try{
			String info;
			BufferedReader in=new BufferedReader(new InputStreamReader(TmpSocket.getInputStream()));
			PrintWriter out=new PrintWriter(TmpSocket.getOutputStream(),true);
			out.println("来之监听服务器的问候：你好");
			String Item1="";
			String Item2="";
			String UserID="";
			while(true){
				info=in.readLine();
				if(info!=null){
					if(info.length()<4){
						Item1="";
						Item2="";
						System.out.println(UserID+">"+info);
						continue;
					}
				}
				else{
					continue;
				}
				Item1=info.substring(0, 4);
				Item2=info.substring(4);
				if(Item1.equals("exit"))
				{
					System.out.println("用户"+UserID+"已经退出系统！");
					CallMain.ExitThread();
					System.out.println("\n\n callback");
					break;
				}
				else if(Item1.equals("lgn:")){
					UserID=Item2;
					CallMain.AddUser(UserID);
					out.println("欢迎"+UserID+"使用本系统！");
				
				}
				else if(Item1.equals("list")){
					Item2=CallMain.GetUserList();
					out.println("当前用户列表："+Item2+"!");
					
				}
				else{
					Item1="";
					Item2="";
					System.out.println(UserID+">"+info);
					
				}
			}
			out.close();
			in.close();
			TmpSocket.close();
		}catch(Exception e){
			System.out.println(e.toString());
		System.exit(1);
		}
	}

}
