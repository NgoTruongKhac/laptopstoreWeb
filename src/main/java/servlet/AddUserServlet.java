package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import bcrypt.BCrypt;
import dao.AddUserDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminPage/addUser")
@MultipartConfig
public class AddUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String pass = req.getParameter("pass");
			String email = req.getParameter("email");
			String phoneNumber = req.getParameter("phoneNumber");
			String sex = req.getParameter("sex");
			String birthdayStr = req.getParameter("birthday");

			Date birthday = Date.valueOf(birthdayStr);
			String avatar = req.getParameter("avatarSrc");
			String role = req.getParameter("role");

			String hashPass = BCrypt.hashpw(pass, BCrypt.gensalt());

			User newUser = new User(firstName, lastName, hashPass, email, phoneNumber);
			newUser.setSex(sex);
			newUser.setBirthday(birthday);
			newUser.setAvatar(avatar);
			newUser.setRole(role);

			AddUserDAO addUser = new AddUserDAO();

			boolean isSuccess = addUser.isAddUser(newUser);

			if (isSuccess) {
//
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				resp.getWriter().write("{\"message\": \"Thêm tài khoản thành công\", \"type\": \"success\"}");

//				  req.getSession().setAttribute("message", "thêm tài khoản thành công");
//				  req.getSession().setAttribute("type", "success");
//				  resp.sendRedirect(req.getContextPath()+"/adminPage/listUser");

			}

		} catch (SQLException e) {
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			if (e.getMessage().contains("Email already exists")) {
				resp.getWriter().write("{\"message\": \"Email đã tồn tại\", \"type\": \"error\"}");
			} else if (e.getMessage().contains("Phone number already exists")) {
				resp.getWriter().write("{\"message\": \"Số điện thoại đã tồn tại\", \"type\": \"error\"}");
			}
		}
	}

}
