package servlet.account;

import java.io.IOException;
import java.util.List;

import dao.account.ListAddressDAO;
import dao.account.UserInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Address;
import model.User;


@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		User user = (User) req.getSession().getAttribute("User");

		int userId = user.getUserId();
		
		UserInfoDAO userInfo=new UserInfoDAO();
		User userRefresh=userInfo.userInfo(userId);
		
		ListAddressDAO getListAddress=new ListAddressDAO();
		
		
		List<Address> listAddress=getListAddress.getListAddress(userId);
		
		req.setAttribute("ListAddress",listAddress);
		
		req.getSession().setAttribute("User",userRefresh);
		
		req.getRequestDispatcher("userInfo.jsp").forward(req, resp);


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
