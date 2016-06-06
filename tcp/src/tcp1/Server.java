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
			System.out.println("\n\nSocket�������Ѿ����رգ�");
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
				System.out.println("\nSocket���������Ѿ�������");
				System.out.println("���ڵȴ��ͻ����������....\n");
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

