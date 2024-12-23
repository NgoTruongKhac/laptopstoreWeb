package servlet;

import java.io.IOException;

import entity.User;
import entity.UserInfoOrder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
//		List<CartItem> listCartItem=(List<CartItem>) req.getSession().getAttribute("ListCartItem");
//		int totalPrice=(int) req.getSession().getAttribute("totalPrice");
		
		
		User user = (User) req.getSession().getAttribute("User");

		int userId = user.getUserId();
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phoneNumber");
		
		String province = req.getParameter("province");
		String district = req.getParameter("district");
		String ward = req.getParameter("ward");
		String street = req.getParameter("street");
		String note=req.getParameter("note");
		UserInfoOrder userInfo=new UserInfoOrder(userId, firstName, lastName, email, phoneNumber, province, district, ward, street, note);
		
		req.getSession().setAttribute("userInfo", userInfo);
		
//		req.setAttribute("totalPrice", totalPrice);
		
		req.setAttribute("includeCss", "styleCSS/payment.css");
		req.setAttribute("nameBtnBack", "Quay lại");
		req.setAttribute("includePage", "components/payment.jsp");
		
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
