package servlet.cart;

import java.io.IOException;

import dao.cart.ListCartCookieDAO;
import dao.cart.QuantityCartDAO;
import dao.cart.UpdateQuantityCartDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/updateQuantityCart")
public class UpdateQuantityCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cartId = Integer.parseInt(req.getParameter("cartId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int cartCount;

		UpdateQuantityCartDAO updateQuantity = new UpdateQuantityCartDAO();

		updateQuantity.setQuantityCart(cartId, quantity);
		User user = (User) req.getSession().getAttribute("User");

		if (user != null) {

			int userId = user.getUserId();

			QuantityCartDAO quantityCart = new QuantityCartDAO();

			cartCount = quantityCart.getCartCount(userId);

			req.getSession().setAttribute("cartCount", cartCount);

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write("{\"cartCount\": " + cartCount + "}");
		} else {
			ListCartCookieDAO lcd = new ListCartCookieDAO(req);
			lcd.updateQuantityCart(cartId, quantity, resp);

			cartCount = lcd.cartCount();

			req.getSession().setAttribute("cartCount", cartCount);

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write("{\"cartCount\": " + cartCount + "}");

		}

	}

}
