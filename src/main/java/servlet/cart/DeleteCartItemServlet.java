package servlet.cart;

import java.io.IOException;

import dao.cart.DeleteCartItemDAO;
import dao.cart.ListCartCookieDAO;
import dao.cart.QuantityCartDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/deleteCartItem")
public class DeleteCartItemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int cartId = Integer.parseInt(req.getParameter("cartId"));

		User user = (User) req.getSession().getAttribute("User");

		int cartCount;

		if (user != null) {

			int userId = user.getUserId();

			DeleteCartItemDAO deleteCartDao = new DeleteCartItemDAO();

			boolean isSuccess = deleteCartDao.isDeleteCartItem(cartId);

			QuantityCartDAO quantityCart = new QuantityCartDAO();

			if (isSuccess) {
				cartCount = quantityCart.getCartCount(userId);

				req.getSession().setAttribute("cartCount", cartCount);

				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				resp.getWriter().write("{\"cartCount\": " + cartCount + "}");

			}
		} else {
			
			
			ListCartCookieDAO lcd = new ListCartCookieDAO(req);
			lcd.deleteCart(cartId, req, resp);

			cartCount = lcd.cartCount();
			req.getSession().setAttribute("cartCount", cartCount);

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write("{\"cartCount\": " + cartCount + "}");

		}

		// delete cart cookie

	}

}
