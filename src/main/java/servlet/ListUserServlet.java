package servlet;

import java.io.IOException;
import java.util.List;

import dao.ListUserDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminPage/listUser")
public class ListUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page=1;
		
		int pageSize=5;
		
		String pageParam = req.getParameter("page");
		if (pageParam != null) {
			page= Integer.parseInt(pageParam); // Chuyển tham số `page` thành số nguyên
		}
		
		ListUserDAO listUserDao=new ListUserDAO();
		
		
		List<User> listUser=listUserDao.GetListUser(page,pageSize);
		
		
		
		int totalUser = listUserDao.getTotalUser();// Tổng số sản phẩm
		int totalPage= (int) Math.ceil((double) totalUser/ pageSize); // Tính tổng số trang

		
		req.setAttribute("ListUser", listUser);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		
		
		req.getRequestDispatcher("/componentsAdmin/manageUser.jsp").forward(req, resp);
	}
	
	
	
	

}
