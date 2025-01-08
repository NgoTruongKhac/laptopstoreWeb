package servlet.admin.manage_user;

import java.io.IOException;

import dao.admin.manage_user.DeleteUserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/adminPage/deleteUser")
public class DeleteUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int userId=Integer.parseInt(req.getParameter("userId"));
		int page=Integer.parseInt(req.getParameter("page"));
		
		
		DeleteUserDAO deleteUser=new DeleteUserDAO();
		boolean isSuccess=deleteUser.isDeleteUser(userId);
		
		
		if(isSuccess) {
			req.getRequestDispatcher("/adminPage/renderListUser?page="+page).forward(req, resp);
		}
		
		
		
	}
	
	
	
	

}
