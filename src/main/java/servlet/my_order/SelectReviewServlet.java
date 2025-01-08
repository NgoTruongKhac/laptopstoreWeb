package servlet.my_order;

import java.io.IOException;
import java.util.List;

import dao.admin.manage_order.OrderDetailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OrderDetail;

@WebServlet("/selectReview")
public class SelectReviewServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int pageOrder = Integer.parseInt(req.getParameter("pageOrder"));
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		OrderDetailDAO odd = new OrderDetailDAO();

		List<OrderDetail> listOrderDetail = odd.getListOrderDetail(orderId);

		req.setAttribute("ListOrderDetail", listOrderDetail);
		req.setAttribute("pageOrder", pageOrder);

		req.getRequestDispatcher("/components/selectReview.jsp").forward(req, resp);

	}

}
