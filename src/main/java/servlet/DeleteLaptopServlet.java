package servlet;

import java.io.IOException;

import dao.DeleteLaptopDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.PageContext;

@WebServlet("/adminPage/deleteLaptop")
public class DeleteLaptopServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int laptopId = Integer.parseInt(req.getParameter("laptopId"));
		int pageLaptop = Integer.parseInt(req.getParameter("pageLaptop"));

		DeleteLaptopDAO deleteLaptopDao = new DeleteLaptopDAO();

		boolean isSuccess = deleteLaptopDao.deleteLaptop(laptopId);
		
		if (isSuccess) {

			resp.sendRedirect(req.getContextPath() + "/adminPage/listLaptop?pageLaptop=" + pageLaptop);

		}

	}

}
