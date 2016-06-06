package sendorresponse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VoteServerTCP {
	public static void main(String args[]) throws Exception {
		if (args.length != 1) {
			throw new IllegalArgumentException("Parameter(s):<Port>");
		}
		int port = Integer.parseInt(args[0]);
		ServerSocket servSock = new ServerSocket(port);
		VoteMsgCoder coder = new VoteMsgBinCoder();
		VoteService service = new VoteService();
		while (true) {
			Socket clntSock = servSock.accept();
			System.out.println("Handing client at" + clntSock.getRemoteSocketAddress());
			Framer framer = new LengthFramer(clntSock.getInputStream());
			try {
				byte[] req;
				while ((req = framer.nextMsg()) != null) {
					System.out.println("received message(" + req.length + "bytes)");
					VoteMsg responseMsg = service.handleRequest(coder.fromWire(req));
					framer.frameMsg(coder.toWire(responseMsg), clntSock.getOutputStream());
				}
			} catch (IOException ioe) {
				System.err.println("Error handing client:" + ioe.getMessage());
			} finally {
				System.out.println("Closeing connection");
				clntSock.close();
			}
		}
	}

}
