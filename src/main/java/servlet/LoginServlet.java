package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import dao.LoginDAO;
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

			if (!Iscorrect) {
				req.getSession().setAttribute("message", "mật khẩu không đúng!");
				req.getSession().setAttribute("type", "error");
				req.getSession().setAttribute("error", "login");
				req.getRequestDispatcher("index.jsp").include(req, resp);
				return;
			}

			if (user != null) {

				req.getSession().setAttribute("User", user);
				if ("admin".equals(user.getRole())) {
					req.getSession().setAttribute("message", "Đăng nhập thành công");
					req.getSession().setAttribute("type", "success");
					resp.sendRedirect("adminPage.jsp");
					return;
				} else {
					req.getSession().setAttribute("message", "Đăng nhập thành công");
					req.getSession().setAttribute("type", "success");
					resp.sendRedirect("index.jsp");
					return;
				}

			}

			req.getSession().setAttribute("message", "email hoặc sđt không đúng!");
			req.getSession().setAttribute("type", "error");
			req.getSession().setAttribute("error", "login");
			req.getRequestDispatcher("index.jsp").include(req, resp);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
