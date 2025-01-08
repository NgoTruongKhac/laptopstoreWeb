package servlet.admin.manage_order;

import java.io.IOException;
import java.util.List;

import dao.admin.manage_order.ListOrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Order;

@WebServlet("/adminPage/renderListOrder")
public class RenderListOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageOrder = 1;
		int pageSize=5;

		String pageParamOrder = req.getParameter("pageOrder");
		if (pageParamOrder  != null) {
			pageOrder = Integer.parseInt(pageParamOrder);
		}
		
		ListOrderDAO lod=new ListOrderDAO();
		
		List<Order> listOrder=lod.getListOrder(pageOrder, pageSize);
		

		int totalOrder = lod.getTotalOrder();// Tổng số sản phẩm
		int totalPageOrder = (int) Math.ceil((double) totalOrder / pageSize); // Tính tổng số trang

		req.setAttribute("ListOrder", listOrder);
		req.setAttribute("totalPageOrder", totalPageOrder);
		req.setAttribute("pageOrder", pageOrder);


		req.setAttribute("dynamicSection", "componentsAdmin/manageOrder.jsp");
		req.setAttribute("activeOrder", "active");

		req.getRequestDispatcher("/componentsAdmin/manageOrder.jsp").forward(req, resp);
	}
	
	

}
