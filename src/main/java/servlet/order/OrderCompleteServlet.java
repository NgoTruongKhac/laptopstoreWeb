package servlet.order;

import java.io.IOException;
import java.util.List;

import dao.cart.QuantityCartDAO;
import dao.my_order.AddOrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CartItem;
import model.UserInfoOrder;

@WebServlet("/orderComplete")
public class OrderCompleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserInfoOrder userInfo = (UserInfoOrder) req.getSession().getAttribute("userInfo");

		int finalPrice = Integer.parseInt(req.getParameter("finalPrice"));
		String payment=req.getParameter("payment");
		System.out.println(payment);


		AddOrderDAO addOrder = new AddOrderDAO();
		QuantityCartDAO quantityCart = new QuantityCartDAO();
		try {
			@SuppressWarnings("unchecked")
			List<CartItem> listItem = (List<CartItem>) req.getSession().getAttribute("ListCartItem");

			boolean isSuccess = addOrder.addOrderData(userInfo, listItem, payment,finalPrice);

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
