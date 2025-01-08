package servlet.my_order;

import java.io.IOException;

import dao.my_order.ConfirmReceivedDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/confirmReceived")
public class ConfirmReceivedServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pageOrder = Integer.parseInt(req.getParameter("pageOrder"));
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		
		ConfirmReceivedDAO crd=new ConfirmReceivedDAO();
		
		boolean isSuccess=crd.confirmReceived(orderId);
		
		if(isSuccess) {
			
			req.getRequestDispatcher("/renderListMyOrder?pageOrder=" + pageOrder).forward(req, resp);
		}
		
	}
	
	
	

}
