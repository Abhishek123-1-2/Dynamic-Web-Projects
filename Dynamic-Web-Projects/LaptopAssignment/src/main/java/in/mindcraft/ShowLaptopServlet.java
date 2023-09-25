package in.mindcraft;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowLaptopServlet {
	@RequestMapping("/show")
public void show(HttpServletRequest request,HttpServletResponse response) throws IOException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/laptop_shceme","root","root");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM laptop_shceme.laptop1");
			List<String> dataList = new ArrayList<>();
	        ResultSet resultSet = stmt.executeQuery();
	        while(resultSet.next()) {
	            dataList.add(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getDouble(3));
	        }
	        response.getWriter().println(dataList);
	       
	        		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
