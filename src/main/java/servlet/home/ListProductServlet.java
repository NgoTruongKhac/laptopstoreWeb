package servlet.home;

import java.io.IOException;
import java.util.List;

import dao.admin.manage_product.ListLaptopDAO;
import dao.admin.manage_product.ListPeripheralDAO;
import dao.cart.ListCartCookieDAO;
import dao.home.BestSellerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Laptop;
import model.Peripheral;
import model.User;

@WebServlet("")
public class ListProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int amount = 0;

		// list lap top
		ListLaptopDAO listLaptopdao = new ListLaptopDAO();

		List<Laptop> listLaptop = listLaptopdao.getListLaptop(amount);


		req.getServletContext().setAttribute("ListLaptop", listLaptop);

		// list peripheral

		ListPeripheralDAO listPeripheraldao = new ListPeripheralDAO();

		List<Peripheral> listPeripheral = listPeripheraldao.getListPeripheral(amount);
		

		req.getServletContext().setAttribute("ListPeripheral", listPeripheral);

		// list best seller
		BestSellerDAO bestSellerdao = new BestSellerDAO();

		List<Laptop> bestSeller = bestSellerdao.getBestSeller();


		User user = (User) req.getSession().getAttribute("User");

		if (user == null) {

			ListCartCookieDAO lcd = new ListCartCookieDAO(req);
			int cartCount = lcd.cartCount();
			req.getSession().setAttribute("cartCount", cartCount);
		}

		req.getServletContext().setAttribute("BestSeller", bestSeller);

		req.setAttribute("message", req.getSession().getAttribute("message"));
		req.setAttribute("type", req.getSession().getAttribute("type"));
		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}



}
