package servlet.home;

import java.io.IOException;
import java.util.List;

import dao.admin.manage_product.ListLaptopDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Laptop;


@WebServlet("/loadMoreLaptop")
public class LoadMoreLaptopServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int amount = Integer.parseInt(req.getParameter("laptopExist"));
		ListLaptopDAO listLaptopDao=new ListLaptopDAO();
		List<Laptop> listLaptop=listLaptopDao.getListLaptop(amount);
		
		req.setAttribute("ListLaptop", listLaptop);
		
		
		req.getRequestDispatcher("components/listLaptop.jsp").forward(req, resp);
	}
	
	

}
