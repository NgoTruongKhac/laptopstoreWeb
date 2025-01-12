package servlet.account;

import java.io.IOException;

import dao.account.LoginDAO;
import dao.cart.QuantityCartDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO Auto-generated method stub

		try {

			String emailOrPhone = req.getParameter("emailOrPhone");
			String pass = req.getParameter("pass");

			LoginDAO login = new LoginDAO();

			User user = login.isSuccess(emailOrPhone, pass);

			boolean Iscorrect = login.getIsCorrectPass();

			QuantityCartDAO quantityCart = new QuantityCartDAO();

			if (!Iscorrect) {
				req.setAttribute("message", "mật khẩu không đúng!");
				req.setAttribute("type", "error");
				req.setAttribute("error", "login");
				req.getRequestDispatcher("index.jsp").include(req, resp);
				return;
			}

			if (user != null) {

				int cartCount = quantityCart.getCartCount(user.getUserId());

				req.getSession().setAttribute("cartCount", cartCount);

				req.getSession().setAttribute("User", user);
				if ("admin".equals(user.getRole())) {
					req.getSession().setAttribute("message", "Đăng nhập thành công");
					req.getSession().setAttribute("type", "success");
					resp.sendRedirect(req.getContextPath()+"/adminPage");
					return;
				} else {
					req.getSession().setAttribute("message", "Đăng nhập thành công");
					req.getSession().setAttribute("type", "success");
					resp.sendRedirect(req.getContextPath()+"/");
					return;
				}

			}

			req.setAttribute("message", "email hoặc sđt không đúng!");
			req.setAttribute("type", "error");
			req.setAttribute("error", "login");
			req.getRequestDispatcher("index.jsp").include(req, resp);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
