package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminPage")
public class AdminPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setAttribute("message", req.getAttribute("message"));
		req.setAttribute("type", req.getAttribute("type"));
		req.setAttribute("dynamicSection", "componentsAdmin/dashboard.jsp");
		req.setAttribute("activeDashboard", "active");
		
		req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
	}
	
	
	

}
