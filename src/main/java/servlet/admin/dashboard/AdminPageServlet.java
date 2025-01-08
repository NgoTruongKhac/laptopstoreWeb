package servlet.admin.dashboard;

import java.io.IOException;

import dao.admin.dashboard.DashboarDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dashboard;

@WebServlet("/adminPage")
public class AdminPageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DashboarDAO dao=new DashboarDAO();
		
		Dashboard dashboard=dao.getDashboard();
		
		req.setAttribute("Dashboard", dashboard);
		req.setAttribute("message", req.getAttribute("message"));
		req.setAttribute("type", req.getAttribute("type"));
		req.setAttribute("dynamicSection", "componentsAdmin/dashboard.jsp");
		req.setAttribute("activeDashboard", "active");
		
		req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
	}
	
	
	

}
