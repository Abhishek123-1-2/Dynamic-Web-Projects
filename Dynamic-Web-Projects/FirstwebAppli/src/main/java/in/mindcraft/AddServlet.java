package in.mindcraft;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet{
public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	//int a = (int) request.getAttribute("result");
	int a = Integer.parseInt(request.getParameter("num1"));
	int b = Integer.parseInt(request.getParameter("num2"));
	int result=a+b;
	//System.out.println(result);
	//response.getWriter().println("Addition="+result);
	//request.setAttribute("result", result);
	//RequestDispatcher rd = request.getRequestDispatcher("sq");
	//rd.forward(request, response);
	//response.sendRedirect("sq?result="+result);//url rewriting
	//HttpSession session = request.getSession();
	//session.setAttribute("result", result);
	//response.sendRedirect("sq");
	Cookie cookie = new Cookie("result", result+"");//using cookies    
	response.addCookie(cookie);
	response.sendRedirect("sq");
	
}
}
