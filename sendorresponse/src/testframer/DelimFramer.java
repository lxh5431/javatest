package testframer;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DelimFramer
{

    private static final int DELIMITER = '\n';

    /**
     * 添加成帧信息并将信息写入到输出流
     * 
     * @param message
     * @param out
     * @throws IOException
     */
    public void frameMsg(byte[] message, OutputStream out) throws IOException
    {
        for (byte b : message)
        {
           
            if (b == DELIMITER)
            {
                throw new IOException("Message contains delimiter");
            }
        }

        out.write(message);
        out.write(DELIMITER);
        out.flush();
    }

    
    public byte[] nextMsg(InputStream in) throws IOException
    {
        ByteArrayOutputStream messageBuffer = new ByteArrayOutputStream();
        int nextByte;

        
        while ((nextByte = in.read()) != DELIMITER)
        {
            
            if (nextByte == -1)
            {
               
                if (messageBuffer.size() == 0)
                {
                    return null;
                }
                else
                {
                    throw new EOFException("Non-empty message without delimiter");
                }
            }
            messageBuffer.write(nextByte);
        }
        return messageBuffer.toByteArray();
    }
}