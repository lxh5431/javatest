package testframer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient
{

    public static void main(String[] args) throws UnknownHostException,
            IOException
    {
        Socket client = new Socket(InetAddress.getLocalHost(), 8188);
        OutputStream output = client.getOutputStream();
        InputStream input = client.getInputStream();
        DelimFramer delimFramer = new DelimFramer();

        byte[] msg = new String("Hello").getBytes();
        // 发送消息
        delimFramer.frameMsg(msg, output);

        // 接收消息
        byte[] receiveByte = delimFramer.nextMsg(input);
        String receiveMsg = new String(receiveByte);

        System.out.println("Client receive msg:" + receiveMsg);

        input.close();
        output.close();
        client.close();

    }
}