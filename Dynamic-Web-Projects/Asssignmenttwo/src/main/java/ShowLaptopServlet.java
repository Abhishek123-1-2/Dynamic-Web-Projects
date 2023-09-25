import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/slp")
public class ShowLaptopServlet extends HttpServlet{
public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lap_schemaa","root","root");
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM lap_schemaa.laptop");
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
