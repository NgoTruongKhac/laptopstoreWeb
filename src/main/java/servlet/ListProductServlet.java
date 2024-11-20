package servlet;

import java.io.IOException;
import java.util.List;

import dao.BestSellerDAO;
import dao.ListLaptopDAO;
import dao.ListPeripheralDAO;
import entity.Laptop;
import entity.Peripheral;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class ListProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int amount=0;
		
		
		//list lap top
		ListLaptopDAO listLaptopdao = new ListLaptopDAO();

		List<Laptop> listLaptop = listLaptopdao.getListLaptop(amount);

		req.getServletContext().setAttribute("ListLaptop", listLaptop);
		
		//list peripheral
		
		
		
		ListPeripheralDAO listPeripheraldao=new ListPeripheralDAO();
		
		List<Peripheral> listPeripheral=listPeripheraldao.getListPeripheral(amount);

		req.getServletContext().setAttribute("ListPeripheral", listPeripheral);
		
		
	
		// list  best seller
		BestSellerDAO bestSellerdao = new BestSellerDAO();

		List<Laptop> bestSeller = bestSellerdao.getBestSeller();

		req.getServletContext().setAttribute("BestSeller", bestSeller);


		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
