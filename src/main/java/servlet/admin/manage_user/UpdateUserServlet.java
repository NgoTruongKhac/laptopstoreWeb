package servlet.admin.manage_user;

import java.io.IOException;
import java.sql.Date;

import dao.admin.manage_user.UpdateUserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;


@WebServlet("/adminPage/updateUser")
@MultipartConfig
public class UpdateUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page=Integer.parseInt(req.getParameter("page"));
		int userId=Integer.parseInt(req.getParameter("userId"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phoneNumber");
		String sex = req.getParameter("sex");
		String birthdayStr = req.getParameter("birthday");

		Date birthday = Date.valueOf(birthdayStr);
		String avatar = req.getParameter("avatarSrc");
		String role = req.getParameter("role");
		
		
		User user=new User(firstName, lastName, "", email, phoneNumber);
		user.setUserId(userId);
		user.setSex(sex);
		user.setBirthday(birthday);
		user.setAvatar(avatar);
		user.setRole(role);
		
		UpdateUserDAO updateUser=new UpdateUserDAO();
		boolean isSuccess=updateUser.isUpdateUser(user);
		
		if(isSuccess) {
			
			resp.sendRedirect(req.getContextPath() + "/adminPage/renderListUser?page=" + page);
		}
		
	}
	
	

}
