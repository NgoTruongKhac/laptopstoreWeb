package servlet.admin.manage_order;

import java.io.IOException;
import java.util.List;

import dao.admin.manage_order.OrderDetailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OrderDetail;
import model.UserInfoOrder;

@WebServlet("/adminPage/orderDetail")
public class DetailOrderServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pageOrder=Integer.parseInt(req.getParameter("pageOrder"));
		int orderId=Integer.parseInt(req.getParameter("orderId"));
		OrderDetailDAO odd=new OrderDetailDAO();
		
		List<OrderDetail> listOrderDetail=odd.getListOrderDetail(orderId);
		
		UserInfoOrder userInfo=odd.getUserInfoOrder(orderId);
		
		req.setAttribute("ListOrderDetail", listOrderDetail);
		req.setAttribute("userInfo", userInfo);
		req.setAttribute("pageOrder", pageOrder);
		
		req.getRequestDispatcher("/componentsAdmin/orderDetail.jsp").forward(req, resp);
		
		
	}
	
	
	

}
