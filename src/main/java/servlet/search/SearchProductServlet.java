package servlet.search;

import java.io.IOException;
import java.util.List;

import dao.search.SearchProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Laptop;
import model.Peripheral;

@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
