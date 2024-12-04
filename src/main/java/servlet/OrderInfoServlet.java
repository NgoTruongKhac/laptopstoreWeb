package servlet;

import java.io.IOException;
import java.util.List;

import dao.AddressDefaultDAO;
import dao.UserInfoDAO;
import entity.Address;
import entity.CartItem;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderInfo")
public class OrderInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<CartItem> listCartItem=(List<CartItem>) req.getSession().getAttribute("ListCartItem");
		int totalPrice=(int) req.getSession().getAttribute("totalPrice");
		
		User user = (User) req.getSession().getAttribute("User");

		int userId = user.getUserId();
		
		UserInfoDAO userInfoDao=new UserInfoDAO();
		User userInfo=userInfoDao.userInfo(userId);
		AddressDefaultDAO addressDefaultDao=new AddressDefaultDAO();
		
		Address address=addressDefaultDao.getAddressDefault(userId);
		
		if(address!=null) {
			req.setAttribute("Address", address);
		}
		req.setAttribute("User", user);
		

		req.setAttribute("includeCss", "styleCSS/orderInfo.css");
		req.setAttribute("nameBtnBack", "Quay lại");
		req.setAttribute("includePage", "components/orderInfo.jsp");
		req.setAttribute("ListCartItem", listCartItem);
		req.setAttribute("totalPrice", totalPrice);
		
		

		req.getRequestDispatcher("cart.jsp").forward(req, resp);

	}

}
