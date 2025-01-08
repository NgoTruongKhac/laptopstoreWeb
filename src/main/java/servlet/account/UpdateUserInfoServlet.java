package servlet.account;

import java.io.IOException;
import java.sql.Date;

import dao.account.UpdateUserInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/updateUserInfo")
public class UpdateUserInfoServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		User user= (User) req.getSession().getAttribute("User");
		
		int userId=user.getUserId();

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");

		String sex = req.getParameter("sex");

		String birthdayStr = req.getParameter("birthday");
		
		String avatarSrc=req.getParameter("avatarSrc");
		String phoneNumber=req.getParameter("phoneNumber");

		Date birthday = Date.valueOf(birthdayStr);

		User userUpdate = new User(firstName, lastName, sex, birthday, avatarSrc,phoneNumber);

		UpdateUserInfoDAO updateUser = new UpdateUserInfoDAO();

		boolean isUpdate = updateUser.isUpdate(userUpdate, userId);

		if (isUpdate) {
			req.setAttribute("message", "Lưu thông tin thành công!");
		    req.setAttribute("type", "success");


		    req.getRequestDispatcher("/userInfo").forward(req, resp);
		} 

	}

}
