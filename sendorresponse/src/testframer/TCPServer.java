package testframer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer
{

	public static void main(String[] args) throws IOException
    {
        DelimFramer delimFramer = new DelimFramer();

        ServerSocket server = new ServerSocket(8188);
        OutputStream output;
        InputStream input;

        while (true)
        {
            Socket client = server.accept();

            System.out.println("Handing client at "
                    + client.getRemoteSocketAddress());

            output = client.getOutputStream();
            input = client.getInputStream();

            byte[] msg = delimFramer.nextMsg(input);

            System.out.println("Server receive msg:" + new String(msg));

            delimFramer.frameMsg(msg, output);
        }
    }
}