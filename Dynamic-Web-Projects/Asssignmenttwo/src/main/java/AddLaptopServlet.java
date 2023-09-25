import java.io.IOException;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lap")
public class AddLaptopServlet extends HttpServlet{
public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
	int lid=Integer.parseInt(request.getParameter("lid"));
	String make = request.getParameter("make");
	int cost = Integer.parseInt(request.getParameter("cost"));	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/lap_schemaa","root","root");
		PreparedStatement pstmt = conn.prepareStatement("insert into Laptop values(?,?,?)");
		pstmt.setInt(1,lid);
		pstmt.setString(2, make);
		pstmt.setDouble(3, cost);
		boolean status = pstmt.execute();
		/*
		 * if(status==true) { response.sendRedirect("created.jsp");
		 * response.getWriter().println("Record Inserted Sucessfully"); }
		 */
		HttpSession session1 = request.getSession();
		session1.setAttribute("lid", lid);
		session1.setAttribute("make", make);
		session1.setAttribute("cost", cost);
		response.sendRedirect("created.jsp");
		response.getWriter().println("Record Inserted Sucessfully");
		conn.close();
			


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
