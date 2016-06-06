package sourceviewwetest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class SourceViewer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length>0){
			try{
				URL u=new URL(args[0]);
				InputStream in=u.openStream();
				in=new BufferedInputStream(in);
				Reader r=new InputStreamReader(in);
				int c;
				while((c=r.read())!=-1){
					System.out.println((char)c);
				}
				
			}
			catch(MalformedURLException ex){
				System.out.println(args[0]+"is not a parseable URL");
				
				
			}
			catch(IOException ex){
				System.out.println(ex);
					
				}
			
			}
		}

	}


