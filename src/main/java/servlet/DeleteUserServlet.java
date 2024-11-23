package servlet;

import java.io.IOException;

import dao.DeleteUserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/adminPage/deleteUser")
public class DeleteUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int userId=Integer.parseInt(req.getParameter("userId"));
		int page=Integer.parseInt(req.getParameter("page"));
		
		
		DeleteUserDAO deleteUser=new DeleteUserDAO();
		boolean isSuccess=deleteUser.isDeleteUser(userId);
		
		if(isSuccess) {
			
			
			resp.sendRedirect(req.getContextPath() + "/adminPage/listUser?page=" + page);
			
		}
		
		
		
	}
	
	
	
	

}
