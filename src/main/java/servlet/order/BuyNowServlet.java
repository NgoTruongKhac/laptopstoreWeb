package servlet.order;

import java.io.IOException;
import java.util.List;

import dao.account.AddressDefaultDAO;
import dao.my_order.BuyNowDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Address;
import model.CartItem;
import model.User;

@WebServlet("/buyNow")
public class BuyNowServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int productId = Integer.parseInt(req.getParameter("productId"));

		BuyNowDAO buy = new BuyNowDAO();

		List<CartItem> listCartItem = buy.getItem(productId);

		int totalPrice = listCartItem.get(0).getPrice();

		User user = (User) req.getSession().getAttribute("User");

		if (user != null) {
			int userId = user.getUserId();

			AddressDefaultDAO addressDefaultDao = new AddressDefaultDAO();

			Address address = addressDefaultDao.getAddressDefault(userId);

			if (address != null) {
				req.setAttribute("Address", address);
			}

			req.setAttribute("User", user);
			req.setAttribute("includeCss", "styleCSS/orderInfo.css");
			req.setAttribute("nameBtnBack", "Quay lại");
			req.setAttribute("includePage", "components/orderInfo.jsp");
			req.getSession().setAttribute("ListCartItem", listCartItem);
			req.getSession().setAttribute("totalPrice", totalPrice);

			req.getRequestDispatcher("cart.jsp").forward(req, resp);

		} else {

			req.setAttribute("includeCss", "styleCSS/orderInfo.css");
			req.setAttribute("nameBtnBack", "Quay lại");
			req.setAttribute("includePage", "components/orderInfo.jsp");
			req.getSession().setAttribute("ListCartItem", listCartItem);
			req.getSession().setAttribute("totalPrice", totalPrice);
			req.getRequestDispatcher("cart.jsp").forward(req, resp);

		}
	}

}
