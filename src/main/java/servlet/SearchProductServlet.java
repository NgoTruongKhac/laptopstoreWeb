package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import dao.SearchProductDAO;
import entity.Laptop;
import entity.Peripheral;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchText=req.getParameter("searchText");
	
		SearchProductDAO spd=new SearchProductDAO();
		
		List<Laptop> listLaptop=spd.getListLaptop(searchText);
		List<Peripheral> listPeripheral=spd.getListPeripheral(searchText);
		
	
		
		req.setAttribute("ListLaptop", listLaptop);
		req.setAttribute("ListPeripheral", listPeripheral);
		req.setAttribute("searchText", searchText);
		
		req.getRequestDispatcher("searchProduct.jsp").forward(req, resp);
		
	}

}
