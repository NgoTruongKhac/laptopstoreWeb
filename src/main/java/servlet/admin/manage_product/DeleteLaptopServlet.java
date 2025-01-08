package servlet.admin.manage_product;

import java.io.IOException;

import dao.admin.manage_product.DeleteLaptopDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminPage/deleteLaptop")
public class DeleteLaptopServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
