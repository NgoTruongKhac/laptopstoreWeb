package servlet;

import java.io.IOException;
import java.util.List;

import dao.ListCartDAO;
import dao.QuantityCartDAO;
import entity.CartItem;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewCart")
public class ListCartItemServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		User user = (User) req.getSession().getAttribute("User");
		int userId = user.getUserId();

		ListCartDAO listCartDao = new ListCartDAO();
		List<CartItem> listCart = listCartDao.getListCart(userId);
		QuantityCartDAO quantityCart = new QuantityCartDAO();

		req.setAttribute("ListCart", listCart);

		int cartCount = quantityCart.getCartCount(user.getUserId());

		req.getSession().setAttribute("cartCount", cartCount);

		req.setAttribute("includeCss", "styleCSS/listCart.css");
		req.setAttribute("nameBtnHome", "Tiếp tục mua");
		req.setAttribute("includePage", "components/listCartItem.jsp");

		req.getRequestDispatcher("cart.jsp").forward(req, resp);

	}

}
