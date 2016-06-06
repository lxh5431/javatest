package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	public UserServlet(){
		super();
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out=response.getWriter();
	 request.setCharacterEncoding("UTF-8");
	 String username=request.getParameter("username");
	out.println("<html>");
	out.println("<body>");
	out.println("ÓÃ»§Ãû£º"+username+"<br>");
	out.println("<body>");
	out.println("<html>");
	out.close();
	}

}
