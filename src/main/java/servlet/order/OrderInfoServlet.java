package servlet.order;

import java.io.IOException;
import java.util.List;

import dao.account.AddressDefaultDAO;
import dao.cart.ListCartCookieDAO;
import dao.cart.ListCartItemOrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Address;
import model.CartItem;
import model.User;

@WebServlet("/orderInfo")
public class OrderInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String[] listProductId = req.getParameterValues("selectCartItem");

		int totalPrice = Integer.parseInt(req.getParameter("totalPrice"));

		User user = (User) req.getSession().getAttribute("User");

		if (user != null) {

			ListCartItemOrderDAO dao = new ListCartItemOrderDAO();

			List<CartItem> listCartItem = dao.listCartItemOrder(listProductId);
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

			ListCartCookieDAO lcd = new ListCartCookieDAO(req);

			List<CartItem> listCartItem = lcd.getCartItemsFromCookie(listProductId);
			
			req.setAttribute("includeCss", "styleCSS/orderInfo.css");
			req.setAttribute("nameBtnBack", "Quay lại");
			req.setAttribute("includePage", "components/orderInfo.jsp");
			req.getSession().setAttribute("ListCartItem", listCartItem);
			req.getSession().setAttribute("totalPrice", totalPrice);
			req.getRequestDispatcher("cart.jsp").forward(req, resp);

		}

	}

}
