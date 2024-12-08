package servlet;

import java.io.IOException;

import dao.EditLaptopDAO;
import entity.Laptop;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detailLaptop")

public class DetailLaptopServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		int laptopId = Integer.parseInt(req.getParameter("productId"));

		EditLaptopDAO editlaptop = new EditLaptopDAO();

		Laptop laptop = editlaptop.getLaptop(laptopId);

		req.setAttribute("Laptop", laptop);
		
		req.getRequestDispatcher("detailLaptop.jsp").forward(req, resp);

	}

}
