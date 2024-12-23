package servlet;

import java.io.IOException;

import dao.ConfirmOrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/adminPage/confirmOrder")
public class ConfirmOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int orderId=Integer.parseInt(req.getParameter("orderId"));
		int pageOrder=Integer.parseInt(req.getParameter("pageOrder"));
		
		ConfirmOrderDAO cod=new ConfirmOrderDAO();
		
		boolean isSuccess=cod.confirmOrder(orderId);
		
		if(isSuccess) {
			
			req.getRequestDispatcher("/adminPage/renderListOrder").forward(req, resp);
			
	}
	
	}

}
