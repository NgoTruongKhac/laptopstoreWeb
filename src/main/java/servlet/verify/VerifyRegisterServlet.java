package servlet.verify;

import java.io.IOException;

import bcrypt.BCrypt;
import dao.account.RegisterDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/verifyCode")
public class VerifyRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String verificationCode = (String) req.getSession().getAttribute("verificationCode");		
		String ConfirmverificationCode = req.getParameter("verificationCode");
		String email = (String) req.getSession().getAttribute("email");
		String firstName = (String) req.getSession().getAttribute("firstName");
		String lastName = (String) req.getSession().getAttribute("lastName");
		String pass = (String) req.getSession().getAttribute("pass");
		String hashedPassword = BCrypt.hashpw(pass, BCrypt.gensalt());

		User user = new User(firstName,lastName, hashedPassword, email, null);

		
		long verificationTime = (long) req.getSession().getAttribute("verificationTime");

		long currentTime = System.currentTimeMillis();

		if (currentTime - verificationTime > 300000) {

			req.setAttribute("message", "mã xác nhận đã hết hạn.");
			req.setAttribute("type", "error");
			req.getRequestDispatcher("verify.jsp").forward(req, resp);

			return;

		}

		if (!verificationCode.equals(ConfirmverificationCode) ) {
			req.setAttribute("message", "Mã xác nhận không đúng.");
			req.setAttribute("type", "error");
			req.getRequestDispatcher("verify.jsp").forward(req, resp);
			return;
		}
		

		RegisterDAO registerDAO = new RegisterDAO();
		


		boolean isVerified = registerDAO.verifyCode(user);
		

		if (isVerified) {

			req.setAttribute("message", "Đăng ký thành công! Bạn có thể đăng nhập.");
			req.setAttribute("type", "success");
			
			req.getSession().removeAttribute("verificationCode");
			req.getSession().removeAttribute("email");
			req.getSession().removeAttribute("firstName");
			req.getSession().removeAttribute("lastName");
			req.getSession().removeAttribute("pass");
			req.getSession().removeAttribute("verificationTime");

			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}


	}

}
