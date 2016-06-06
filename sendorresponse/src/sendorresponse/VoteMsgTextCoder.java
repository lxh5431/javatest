package sendorresponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class VoteMsgTextCoder implements VoteMsgCoder {
	public static final String MAGIC="Voting";
	public static final String VOTESTR="v";
	public static final String INQSTR="i";
	public static final String RESPOMSESTR="R";
	
	public static final String CHARSETNAME="US-ASCII";
	public static final String DELIMSTR="";
	public static final int MAX_WIRE_LENGTH=2000;
	public byte[] toWire(VoteMsg msg)throws IOException{
		String msgString=MAGIC+DELIMSTR+(msg.isInquiry()?INQSTR:VOTESTR)
				+DELIMSTR+(msg.isResponse()?RESPOMSESTR+DELIMSTR:"")
				+Integer.toString(msg.getCandidateID())+DELIMSTR
						+Long.toString(msg.getVoteCount());
		byte data[]=msgString.getBytes(CHARSETNAME);
		return data;
	}
	public VoteMsg fromWire(byte[] message)throws IOException{
		ByteArrayInputStream msgStream=new ByteArrayInputStream(message);
		Scanner s=new Scanner(new InputStreamReader(msgStream,CHARSETNAME));
		boolean isInquiry;
		boolean isResponse;
		int candidateID;
	    long voteCount;
	    String token;
	    
	    try{
	    	token=s.next();
	    	if(!token.equals(MAGIC)){
	    		throw new IOException("Bad string:"+token);
	    	}
	    	token=s.next();
	    	if(token.equals(VOTESTR)){
	    		isInquiry=false;
	    	}else if(!token.equals(INQSTR)){
	    		throw new IOException("Bad vote/inq indicator:"+token);
	    	}else{
	    		isInquiry=true;
	    	}
	    	token=s.next();
	    	if(token.equals(RESPOMSESTR)){
	    	isResponse=true;
	    	token=s.next();
	    	}else{
	    		isResponse=false;
	    	}
	    	candidateID=Integer.parseInt(token);
	    	if(isResponse){
	    		token=s.next();
	    		voteCount=Long.parseLong(token);
	    	}else{
	    		voteCount=0;
	    	}
	    	}
	    catch(IOException ioe){
	    	throw new IOException("Parse error...");
	    }
	    return new VoteMsg(isResponse,isInquiry,candidateID,voteCount);
	}
	

}