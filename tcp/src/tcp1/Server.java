package tcp1;

import java.net.ServerSocket;
import java.net.Socket;

public  class Server implements MyEvent {
	private ServerSocket server;
	private Socket socket;
	private int UserCount=0;
	private String UserList="";
	private MyThread Th;
	public static void main(String[] args){
		@SuppressWarnings("unused")
		Server TempServer=new Server();
	}
	public void ExitThread(){
		try{
			server.close();
			System.out.println("\n\nSocket监听器已经被关闭！");
		}
		catch(Exception e){
			e.toString();
		}
		return;
	}
		public int GetUserCount(){
			return UserCount;
		}
		public void AddUser(String UserID){
			UserCount++;
			UserList=UserList+UserID+";";
			return;
		}
		public String GetUserList(){
			return UserList;
		}
		public Server(){
			try{
				server=new ServerSocket(1415);
				System.out.println("\nSocket监听服务已经启动。");
				System.out.println("正在等待客户程序的请求....\n");
			while(true){
				socket=server.accept();
				Th=new MyThread(socket,this);
				Th.start();
				if(UserCount==3){
					break;
				}
			}
			server.close();
			}catch(Exception e){
				System.out.println(e.toString());
			System.exit(1);
			}
	}
		@Override
		public int GetUserCout() {
			// TODO Auto-generated method stub
			return 0;
		}

}

