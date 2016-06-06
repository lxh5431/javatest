package httpstest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {
	public static void main(String[] args)throws Exception {
		String infile="e:\\test.txt";
		String outfile="e:\\test1.txt";
		FileInputStream fin=new FileInputStream(infile);
		FileOutputStream fout=new FileOutputStream(outfile);
		FileChannel fcin=fin.getChannel();
		FileChannel fcout=fout.getChannel();
		
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		while(true){
			buffer.clear();
			int r=fcin.read(buffer);
			if(r==-1){
				break;
			}
			buffer.flip();
			fcout.write(buffer);
		}
		
	}

}
