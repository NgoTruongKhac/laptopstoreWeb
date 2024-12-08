package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detailProduct")
public class DetailProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int productId = Integer.parseInt(req.getParameter("productId"));
		String type=req.getParameter("type");
		

		if("laptop".equals(type)) {
			resp.sendRedirect(req.getContextPath()+"/detailLaptop?productId="+productId);
		}else {
			resp.sendRedirect(req.getContextPath()+"/detailPeripheral?productId="+productId);
		}

	}

}
