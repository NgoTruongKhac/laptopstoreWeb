package servlet.verify;

import java.io.IOException;

import dao.account.ForgotPassDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verifyForgotPass")
public class VerifyFogotPass extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String verificationCode = (String) req.getSession().getAttribute("verificationCode");		
		String ConfirmverificationCode = req.getParameter("verificationCode");
		String email = (String) req.getSession().getAttribute("email");
		String newPass = (String) req.getSession().getAttribute("newPass");
		
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
		
		ForgotPassDAO forgotPass = new ForgotPassDAO();
		boolean isChangePass = forgotPass.isChangePass(newPass, email);
		
		if (isChangePass) {
			req.setAttribute("message", "Đổi mật khẩu thành công! Bạn có thể đăng nhập.");
			req.setAttribute("type", "success");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	
	
	
	

}
