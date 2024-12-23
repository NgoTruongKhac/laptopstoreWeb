package servlet;

import java.io.IOException;
import java.util.List;

import dao.OrderDetailDAO;
import entity.OrderDetail;
import entity.UserInfoOrder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/myOrderDetail")
public class DetailMyOrderServlet extends HttpServlet{
	
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
		
		req.getRequestDispatcher("/components/myOrderDetail.jsp").forward(req, resp);
		
		
	}
	

}
