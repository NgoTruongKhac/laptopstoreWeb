package servlet.verify;

import java.io.IOException;

import dao.account.ChangeEmailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verifyChangeEmail")
public class VerifyChangeEmail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String verificationCode = (String) req.getSession().getAttribute("verificationCode");		
		String ConfirmverificationCode = req.getParameter("verificationCode");
		long verificationTime = (long) req.getSession().getAttribute("verificationTime");
		int userId=(int) req.getSession().getAttribute("userId");
		String newEmail = (String) req.getSession().getAttribute("newEmail");
		
		
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
		
		ChangeEmailDAO changeEmail=new ChangeEmailDAO();
		boolean isChangeEmail=changeEmail.isChangeEmail(newEmail, userId);
		
		
		if (isChangeEmail) {
			req.setAttribute("emailOrPhone", newEmail);
			req.setAttribute("message", "Thay đổi email thành công.");
			req.setAttribute("type", "success");
			
			req.getSession().removeAttribute("verificationCode");
			req.getSession().removeAttribute("newEmail");	
			req.getSession().removeAttribute("verificationTime");
			
			req.getRequestDispatcher("/userInfo");
		}
		
	}
	
	

}
