package servlet;

import java.io.IOException;

import dao.AddToCartDAO;
import dao.QuantityCartDAO;
import entity.Cart;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(req.getParameter("productId"));
		User user = (User) req.getSession().getAttribute("User");
		int userId = user.getUserId();

		String productType = productId % 2 == 0 ? "laptop" : "peripheral";

		Cart cart = new Cart(userId, productId, productType, 1);

		AddToCartDAO addToCart = new AddToCartDAO();
		QuantityCartDAO quantityCart=new QuantityCartDAO();

		boolean isSuccess = addToCart.isAddToCart(cart);

		if (isSuccess) {

			int cartCount = quantityCart.getCartCount(userId); // Hàm mới để lấy số lượng giỏ hàng

			req.getSession().setAttribute("cartCount", cartCount);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");

			String jsonResponse = "{\"cartCount\": " + cartCount + "}";
			resp.getWriter().write(jsonResponse);

		} else {
			System.out.println("error");
		}

	}

}
