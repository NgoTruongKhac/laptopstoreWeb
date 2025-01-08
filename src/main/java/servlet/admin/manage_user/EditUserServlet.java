package servlet.admin.manage_user;

import java.io.IOException;

import dao.admin.manage_user.EditUserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/adminPage/editUser")
public class EditUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int userId=Integer.parseInt(req.getParameter("userId"));
		
		int page=Integer.parseInt(req.getParameter("page"));
		
		EditUserDAO editUser=new EditUserDAO();
		
		User user=editUser.getUser(userId);
		
		
		
		
		req.setAttribute("User", user);
		req.setAttribute("page", page);
		
		req.getRequestDispatcher("/componentsAdmin/editUser.jsp").forward(req, resp);
		
		
		
		
	}
	
	

}
