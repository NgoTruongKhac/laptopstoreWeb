package servlet;

import java.io.IOException;

import dao.DeleteAddressDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteAddress")
public class DeleteAddress extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int addressId = Integer.parseInt(req.getParameter("addressId"));

		DeleteAddressDAO deleteAdress = new DeleteAddressDAO();

		boolean isSuccess = deleteAdress.deleteAdress(addressId);
		if (isSuccess) {
			req.getSession().setAttribute("message", "Xoá địa chỉ thành công");
			req.getSession().setAttribute("type", "success");
			resp.sendRedirect(req.getContextPath() + "/userInfo");

		}

	}

}
