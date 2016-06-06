package httptest;

import java.net.MalformedURLException;
import java.net.URL;

public class ProtocolTester {
	public static void main(String[] args){
		testProtocol("http://www.abc.org");
		testProtocol("https://www.amazon.com/exec/obidos/order2");
		testProtocol("ftp://metalab.unc.edu/pub/languages/java/javafaq/");
		
		
	}
	private static void testProtocol(String url){
		try{
			URL u=new URL(url);
			System.out.println(u.getProtocol()+ "is supported");
		}
		catch(MalformedURLException ex){
			String protocol=url.substring(0,url.indexOf(":"));
			System.out.println(protocol+ "is not supported");
		}
	}

}
