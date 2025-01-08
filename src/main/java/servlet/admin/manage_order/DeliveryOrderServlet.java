package servlet.admin.manage_order;

import java.io.IOException;

import dao.admin.manage_order.DeliveryOrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminPage/delivery")
public class DeliveryOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int orderId = Integer.parseInt(req.getParameter("orderId"));
		int pageOrder = Integer.parseInt(req.getParameter("pageOrder"));

		DeliveryOrderDAO cod = new DeliveryOrderDAO();

		boolean isSuccess = cod.deliveryOrder(orderId);

		if (isSuccess) {

			req.getRequestDispatcher("/adminPage/renderListOrder?pageOrder=" + pageOrder).forward(req, resp);

		}

	}

}
