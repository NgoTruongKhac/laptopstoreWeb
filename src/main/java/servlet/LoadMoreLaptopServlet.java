package servlet;

import java.io.IOException;
import java.util.List;

import dao.ListLaptopDAO;
import entity.Laptop;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/loadMoreLaptop")
public class LoadMoreLaptopServlet extends HttpServlet{

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
