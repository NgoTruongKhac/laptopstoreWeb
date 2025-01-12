package servlet.admin.manage_user;

import java.io.IOException;
import java.util.List;

import dao.admin.manage_user.ListUserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/adminPage/renderListUser")
public class RenderlistUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int page = 1;

		int pageSize = 5;

		String pageParam = req.getParameter("page");
		if (pageParam != null) {
			page = Integer.parseInt(pageParam); // Chuyển tham số `page` thành số nguyên
		}

		ListUserDAO listUserDao = new ListUserDAO();

		List<User> listUser = listUserDao.GetListUser(page, pageSize);

		int totalUser = listUserDao.getTotalUser();// Tổng số sản phẩm
		int totalPage = (int) Math.ceil((double) totalUser / pageSize); // Tính tổng số trang

		req.setAttribute("ListUser", listUser);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);


		req.setAttribute("dynamicSection", "componentsAdmin/manageUser.jsp");
		req.setAttribute("activeUser", "active");

		req.getRequestDispatcher("/componentsAdmin/manageUser.jsp").forward(req, resp);
	}
	
	
	

}
