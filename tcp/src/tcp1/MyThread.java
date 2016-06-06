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
			out.println("��֮�������������ʺ����");
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
					System.out.println("�û�"+UserID+"�Ѿ��˳�ϵͳ��");
					CallMain.ExitThread();
					System.out.println("\n\n callback");
					break;
				}
				else if(Item1.equals("lgn:")){
					UserID=Item2;
					CallMain.AddUser(UserID);
					out.println("��ӭ"+UserID+"ʹ�ñ�ϵͳ��");
				
				}
				else if(Item1.equals("list")){
					Item2=CallMain.GetUserList();
					out.println("��ǰ�û��б�"+Item2+"!");
					
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
