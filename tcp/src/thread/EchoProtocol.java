package thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoProtocol implements Runnable {
	private static final int BUDSIZE = 32;
	private Socket clntsock;
	private Logger logger;

	public EchoProtocol(Socket clntsock, Logger loggeer) {
		this.clntsock = clntsock;
		this.logger = logger;

	}

	public static void handleEchoClient(Socket clntsock, Logger logger) {
		try {
			InputStream in = clntsock.getInputStream();
			OutputStream out = clntsock.getOutputStream();
			int recvMsgSize;
			int totalByteEchoed = 0;
			byte[] echoBuffer = new byte[BUDSIZE];
			while ((recvMsgSize = in.read(echoBuffer)) != -1) {
				out.write(echoBuffer, 0, recvMsgSize);
				totalByteEchoed += recvMsgSize;
			}
			logger.info("Client" + clntsock.getRemoteSocketAddress() + ",echoed" + totalByteEchoed + "byte.");

		}catch(IOException ex){
			logger.log(Level.WARNING,"Exception in echo protocol",ex);
		}
		finally {
			try {
				clntsock.close();
			} catch (IOException e) {

			}
		}
	}

	public void run() {
		handleEchoClient(clntsock, logger);
	}

}
