package servlet;

import java.io.IOException;

import dao.QuantityCartDAO;
import dao.UpdateQuantityCartDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateQuantityCart")
public class UpdateQuantityCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cartId = Integer.parseInt(req.getParameter("cartId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));

		UpdateQuantityCartDAO updateQuantity = new UpdateQuantityCartDAO();

		updateQuantity.setQuantityCart(cartId, quantity);
		User user = (User) req.getSession().getAttribute("User");
		int userId = user.getUserId();

		QuantityCartDAO quantityCart = new QuantityCartDAO();

		int cartCount = quantityCart.getCartCount(userId);

		req.getSession().setAttribute("cartCount", cartCount);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("{\"cartCount\": " + cartCount + "}");

	}

}
