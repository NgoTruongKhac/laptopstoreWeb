package servlet;

import java.io.IOException;
import java.util.List;

import dao.AddressDefaultDAO;
import dao.BuyNowDAO;
import entity.Address;
import entity.CartItem;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buyNow")
public class BuyNowServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int productId = Integer.parseInt(req.getParameter("productId"));

		BuyNowDAO buy = new BuyNowDAO();

		List<CartItem> listCartItem = buy.getItem(productId);

		int totalPrice = listCartItem.get(0).getPrice();

		User user = (User) req.getSession().getAttribute("User");

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

	}

}
