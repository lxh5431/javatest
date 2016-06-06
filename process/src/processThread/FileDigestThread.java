package processThread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileDigestThread extends Thread {
	private File input;
		public FileDigestThread(File input){
			this.input=input;
		}
		public void run(){
			try{
				FileInputStream in=new FileInputStream(input);
				MessageDigest sha=MessageDigest.getInstance("SHA");
				DigestInputStream din=new DigestInputStream(in,sha);
				int b;
				while((b=din.read())!=-1);
				din.close();
				byte[] digest=sha.digest();
				StringBuffer result=new StringBuffer(input.toString());
				result.append(":");
				for(int i=0;i<digest.length;i++){
					result.append(digest[i]+" ");
				}
				System.out.println(result);
				
				}catch(IOException ex){
					System.err.println(ex);
					
			}catch(NoSuchAlgorithmException ex){
				System.out.println(ex);
			}
			
			
		}
		public static void main(String[] args) {
			for(int i=0;i<args.length;i++){
				File f=new File(args[i]);
				Thread t=new FileDigestThread(f);
				t.start();
		}

}
}
