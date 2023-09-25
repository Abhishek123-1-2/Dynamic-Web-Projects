import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddLaptopServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response){
		
		class Laptop{
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
			
		}
		Laptop l1 = new Laptop();
		l1.setLid(Integer.parseInt(request.getParameter("lid")));
		l1.setCost(Integer.parseInt(request.getParameter("cost")));
		l1.setMake(request.getParameter("make"));
		
		
	}
		
	}

