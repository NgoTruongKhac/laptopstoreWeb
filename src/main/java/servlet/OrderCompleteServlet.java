package servlet;

import java.io.IOException;
import java.util.List;

import dao.AddOrderDAO;
import dao.QuantityCartDAO;
import entity.CartItem;
import entity.UserInfoOrder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderComplete")
public class OrderCompleteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserInfoOrder userInfo = (UserInfoOrder) req.getSession().getAttribute("userInfo");

		int finalPrice = Integer.parseInt(req.getParameter("finalPrice"));

		List<CartItem> listItem = (List<CartItem>) req.getSession().getAttribute("ListCartItem");

		AddOrderDAO addOrder = new AddOrderDAO();
		QuantityCartDAO quantityCart = new QuantityCartDAO();
		try {

			boolean isSuccess = addOrder.addOrderData(userInfo, listItem, finalPrice);

			if (isSuccess) {
				int cartCount = quantityCart.getCartCount(userInfo.getUserId());

				req.getSession().setAttribute("cartCount", cartCount);
				req.setAttribute("includeCss", "styleCSS/orderComplete.css");
				req.setAttribute("includePage", "components/orderComplete.jsp");
				req.setAttribute("nameBtnHome", "về trang chủ");
				req.getRequestDispatcher("cart.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
