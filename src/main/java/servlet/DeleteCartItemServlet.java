package servlet;

import java.io.IOException;

import dao.DeleteCartItemDAO;
import dao.QuantityCartDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCartItem")
public class DeleteCartItemServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int cartId = Integer.parseInt(req.getParameter("cartId"));
		User user = (User) req.getSession().getAttribute("User");
		int userId = user.getUserId();

		DeleteCartItemDAO deleteCartDao = new DeleteCartItemDAO();

		boolean isSuccess = deleteCartDao.isDeleteCartItem(cartId);

		QuantityCartDAO quantityCart = new QuantityCartDAO();

		if (isSuccess) {
			int cartCount = quantityCart.getCartCount(userId);
			
			req.getSession().setAttribute("cartCount", cartCount);
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write("{\"cartCount\": " + cartCount + "}");

		} else {
			System.out.println("error");
		}

	}

}
