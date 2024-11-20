package servlet;

import java.io.IOException;

import dao.EditLaptopDAO;
import entity.Laptop;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminPage/editLaptop")
public class EditLaptopServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pageLaptop=Integer.parseInt(req.getParameter("pageLaptop"));
		int laptopId=Integer.parseInt(req.getParameter("laptopId"));
		
		EditLaptopDAO editlaptop=new EditLaptopDAO();
		
		Laptop laptop=editlaptop.getLaptop(laptopId);
		
		req.setAttribute("Laptop", laptop);
		req.setAttribute("pageLaptop", pageLaptop);
		
		
		req.getRequestDispatcher("/componentsAdmin/editLaptop.jsp").forward(req, resp);
		
		
	}
	
	

}
