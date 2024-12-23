package servlet;

import java.io.IOException;
import java.util.List;

import dao.ListOrderDAO;
import dao.MyOrderDAO;
import entity.Order;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/myOrder")
public class MyOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageOrder = 1;
		int pageSize = 5;

		String pageParamOrder = req.getParameter("pageOrder");
		if (pageParamOrder != null) {
			pageOrder = Integer.parseInt(pageParamOrder);
		}

		User user = (User) req.getSession().getAttribute("User");
		int userId = user.getUserId();

		MyOrderDAO myOrderDao = new MyOrderDAO();

		List<Order> listOrder = myOrderDao.getMyOrder(userId, pageOrder, pageSize);

		int totalOrder = myOrderDao.getTotalMyOrder(userId);
		int totalPageOrder = (int) Math.ceil((double) totalOrder / pageSize);
		req.setAttribute("ListOrder", listOrder);
		req.setAttribute("totalPageOrder", totalPageOrder);
		req.setAttribute("pageOrder", pageOrder);
		
		req.getRequestDispatcher("myOrder.jsp").forward(req, resp);

	}

}