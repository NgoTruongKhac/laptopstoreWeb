package servlet.account;

import java.io.IOException;

import dao.account.ChangeEmailDAO;
import email.EmailUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/changeEmail")
public class ChangeEmailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newEmail = req.getParameter("newEmail");

		User user = (User) req.getSession().getAttribute("User");

		int userId = user.getUserId();

		ChangeEmailDAO changeEmail = new ChangeEmailDAO();
		boolean isChange = changeEmail.isSuccess(newEmail);
		
		

		String verificationCode = String.valueOf((int) (Math.random() * 900000) + 100000);

		if (isChange) {
			String subject = "Mã xác nhận thay đổi email";

			EmailUtil.sendEmail(newEmail, subject, verificationCode);
			req.getSession().setAttribute("verificationTime", System.currentTimeMillis());
			req.getSession().setAttribute("verificationCode", verificationCode);
			req.getSession().setAttribute("newEmail", newEmail);
			req.getSession().setAttribute("userId", userId);
			req.getRequestDispatcher("verifyChangeEmail.jsp").forward(req, resp);

		} else {
			req.setAttribute("message", "email đã được sử dụng!");
			req.setAttribute("type", "error");

			 req.getRequestDispatcher("/userInfo").forward(req, resp);
		}

	}

}
