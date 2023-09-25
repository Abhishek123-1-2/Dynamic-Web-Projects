package in.mindcraft;



import java.io.IOException;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@WebServlet("/lap")
@Entity
public class AddLaptopServlet extends HttpServlet{
	
		
			@Id
			private int lid;
			private String make;
			private double cost;
			
		
			public int getLid() {
				return lid;
			}
			public void setLid(int lid) {
				this.lid = lid;
			}
			public String getMake() {
				return make;
			}
			public void setMake(String make) {
				this.make = make;
			}
			public double getCost() {
				return cost;
			}
			public void setCost(double cost) {
				this.cost = cost;
			}
			
			
			
	
	@Override
			public String toString() {
				return "AddLaptopServlet [lid=" + lid + ", make=" + make + ", cost=" + cost + "]";
			}
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int lid = Integer.parseInt(request.getParameter("lid"));
		String make = request.getParameter("make");
		int cost = Integer.parseInt(request.getParameter("cost"));
		AddLaptopServlet l1 = new AddLaptopServlet();
		l1.setLid(lid);
		l1.setCost(cost);
		l1.setMake(make);
		
		
		
		Configuration con = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(l1);
		tx.commit();
		
		HttpSession session1 = request.getSession();
		session1.setAttribute("lid", lid);
		session1.setAttribute("make", make);
		session1.setAttribute("cost", cost);
		response.sendRedirect("output.jsp");
		
		
		
}
}



