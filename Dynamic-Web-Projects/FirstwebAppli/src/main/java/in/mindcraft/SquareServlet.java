package in.mindcraft;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SquareServlet extends HttpServlet{
public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
	//int result= Integer.parseInt(request.getParameter("result"));
	//HttpSession session = request.getSession();
	//int result =(int) session.getAttribute("result") ;
	Cookie [] cookies = request.getCookies();
	int result=0;
		for(Cookie ck:cookies) {
			if(ck.getName().equals("result"))
			{
				result=Integer.parseInt(ck.getValue());
			}
		}
	int sq = result*result;
	//response.getWriter().println("Square of Addition:"+sq);
	HttpSession session = request.getSession();
	session.setAttribute("sq", sq);
	response.sendRedirect("result.jsp");
	
}
}
