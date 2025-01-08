package servlet.cart;

import java.io.IOException;

import dao.cart.AddToCartDAO;
import dao.cart.ListCartCookieDAO;
import dao.cart.QuantityCartDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
import model.User;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(req.getParameter("productId"));
		User user = (User) req.getSession().getAttribute("User");
		int cartCount;

		if (user != null) {
			int userId = user.getUserId();

			Cart cart = new Cart(userId, productId, 1);

			AddToCartDAO addToCart = new AddToCartDAO();
			QuantityCartDAO quantityCart = new QuantityCartDAO();

			boolean isSuccess = addToCart.isAddToCart(cart);

			if (isSuccess) {

				cartCount = quantityCart.getCartCount(userId); // Hàm mới để lấy số lượng giỏ hàng

				req.getSession().setAttribute("cartCount", cartCount);
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");

				String jsonResponse = "{\"cartCount\": " + cartCount + "}";
				resp.getWriter().write(jsonResponse);

			}

		} else {

			// cart cookie
			ListCartCookieDAO lcd = new ListCartCookieDAO(req);
			
			lcd.addToCart(productId, resp);
			cartCount =lcd.cartCount();
			
	         // Gửi phản hồi JSON
	         req.getSession().setAttribute("cartCount", cartCount);
	         resp.setContentType("application/json");
	         resp.setCharacterEncoding("UTF-8");
	         String jsonResponse = "{\"cartCount\": " + cartCount + "}";
	         resp.getWriter().write(jsonResponse);
	     }

	}

}
