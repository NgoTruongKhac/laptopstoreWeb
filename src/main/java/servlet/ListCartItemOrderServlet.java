package servlet;

import java.io.IOException;
import java.util.List;

import dao.ListCartItemOrderDAO;
import entity.CartItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listCartItemOrder")
public class ListCartItemOrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String[] listCartId = req.getParameterValues("selectCartItem");

		int totalPrice = Integer.parseInt(req.getParameter("totalPrice"));

		ListCartItemOrderDAO dao = new ListCartItemOrderDAO();
		
		List<CartItem> listCartItem=dao.listCartItemOrder(listCartId);
		
		
		req.getSession().setAttribute("ListCartItem", listCartItem);
		req.getSession().setAttribute("totalPrice", totalPrice);
		
		
		
		
		
		resp.sendRedirect(req.getContextPath()+"/orderInfo");

	}

}
