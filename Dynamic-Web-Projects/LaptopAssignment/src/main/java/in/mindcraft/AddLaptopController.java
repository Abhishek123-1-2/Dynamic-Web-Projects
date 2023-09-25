package in.mindcraft;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddLaptopController {
	@RequestMapping("/add")
	public void add(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
		int lid = Integer.parseInt(request.getParameter("lid"));
		String make = request.getParameter("make");
		int cost = Integer.parseInt(request.getParameter("cost"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/laptop_shceme","root","root");
			PreparedStatement pstmt = conn.prepareStatement("insert into laptop1 values(?,?,?)");
			pstmt.setInt(1,lid);
			pstmt.setString(2, make);
			pstmt.setInt(3, cost);
			boolean status=pstmt.execute();
			HttpSession session1 = request.getSession();
			session1.setAttribute("lid", lid);
			session1.setAttribute("make", make);
			session1.setAttribute("cost", cost);
			response.sendRedirect("created.jsp");
			response.getWriter().println("Record Inserted Sucessfully");
			conn.close();
	
			
		}catch(ClassNotFoundException e) {
			
			System.out.println(e);
		}
		
		
		
		
	}
	
}
