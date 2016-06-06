package sendorresponse;

import java.io.OutputStream;
import java.net.Socket;

public class VoteClientTC {
	private static final int CANDIDATEID=888;
	
	public static void main(String[] args)throws Exception{
	if(args.length!=2){
		throw new IllegalArgumentException("Parameter(s):<Server><port>");
		
	}
	String destAddr=args[0];
	int destPort=Integer.parseInt(args[1]);
	Socket sock=new Socket(destAddr,destPort);
	OutputStream out=sock.getOutputStream();
	VoteMsgCoder coder=new VoteMsgBinCoder();
	Framer framer=new LengthFramer(sock.getInputStream());
	VoteMsg msg=new VoteMsg(false,true,CANDIDATEID,0);
	byte[] encodedMsg=coder.toWire(msg);
	System.out.println("Sending ibquiry("+encodedMsg.length+"bytes):");
	System.out.println(msg);
	framer.frameMsg(encodedMsg,out);
	msg.setInquiry(false);
	encodedMsg=coder.toWire(msg);
	System.out.println("Sending Vote("+encodedMsg.length+"bytes):");
	System.out.println(msg);
	framer.frameMsg(encodedMsg,out);
	encodedMsg=framer.nextMsg();
	msg=coder.fromWire(encodedMsg);
	System.out.println("Received Response("+encodedMsg.length+"bytes):");
	System.out.println(msg);
	msg=coder.fromWire(framer.nextMsg());
	System.out.println("Received Response("+encodedMsg.length+"bytes):");
	System.out.println(msg);
	sock.close();
	
		
	}

}
