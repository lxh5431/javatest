package demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.Controller;

public class IndexController extends Controller {

	public void index(){

		this.render("/index.jsp");

		}

		public void sayHello(){

		String userName = this.getAttr("userName");

		String sayHello = "Hello " + userName + "£¬welcome to JFinal world.";

		this.setAttr("sayHello", sayHello);

		this.render("/hello.jsp");

		}

		}

