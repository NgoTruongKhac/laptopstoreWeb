package servlet;

import java.io.IOException;

import dao.EditUserDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminPage/editUser")
public class EditUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int userId=Integer.parseInt(req.getParameter("userId"));
		
		int page=Integer.parseInt(req.getParameter("page"));
		
		EditUserDAO editUser=new EditUserDAO();
		
		User user=editUser.getUser(userId);
		
		System.out.println(user.toString());
		
		
		req.setAttribute("User", user);
		req.setAttribute("page", page);
		
		req.getRequestDispatcher("/componentsAdmin/editUser.jsp").forward(req, resp);
		
		
		
		
	}
	
	

}
