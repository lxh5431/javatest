package applettest;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.net.MalformedURLException;
import java.net.URL;

public class ProtocolTesterApplet extends Applet {
	TextArea results = new TextArea();

	public void init() {
		this.setLayout(new BorderLayout());
		this.add("Center", results);
	}

	public void start() {
		String host = "www.peacefire.org";
		String file = "/bypass/surfWatch/";
		String[] schemes = { "http", "https", "ftp", "mailto", "telnet", "file", "ldap", "gopher", "jdbc", "rmi",
				"jndi", "jar", "finger", "daytime", "systemresource" };
		for (int i = 0; i < schemes.length; i++) {
			try {
				URL u = new URL(schemes[i], host, file);
				results.append(schemes[i] + "is supported\r\n");

			} catch (MalformedURLException ex) {
				results.append(schemes[i] + "is not supported\r\n");
			}
		}
	}

}
