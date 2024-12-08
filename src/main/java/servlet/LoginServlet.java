package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AddToCartDAO;
import dao.LoginDAO;
import dao.QuantityCartDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO Auto-generated method stub

		try {

			String emailOrPhone = req.getParameter("emailOrPhone");
			String pass = req.getParameter("pass");

			LoginDAO login = new LoginDAO();

			User user = login.isSuccess(emailOrPhone, pass);

			boolean Iscorrect = login.getIsCorrectPass();
			
			
			QuantityCartDAO quantityCart=new QuantityCartDAO();

			if (!Iscorrect) {
				req.setAttribute("message", "mật khẩu không đúng!");
				req.setAttribute("type", "error");
				req.setAttribute("error", "login");
				req.getRequestDispatcher("index.jsp").include(req, resp);
				return;
			}

			if (user != null) {

				int cartCount=quantityCart.getCartCount(user.getUserId());
				
				req.getSession().setAttribute("cartCount", cartCount);
				
				
				req.getSession().setAttribute("User", user);
				if ("admin".equals(user.getRole())) {
					req.setAttribute("message", "Đăng nhập thành công");
					req.setAttribute("type", "success");
					req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
					return;
				} else {
					req.setAttribute("message", "Đăng nhập thành công");
					req.setAttribute("type", "success");
					req.getRequestDispatcher("index.jsp").forward(req, resp);
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
