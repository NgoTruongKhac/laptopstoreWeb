package servlet.account;

import java.io.IOException;

import dao.account.DeleteAddressDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteAddress")
public class DeleteAddress extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int addressId = Integer.parseInt(req.getParameter("addressId"));

		DeleteAddressDAO deleteAdress = new DeleteAddressDAO();

		boolean isSuccess = deleteAdress.deleteAdress(addressId);
		if (isSuccess) {
			req.setAttribute("message", "Xoá địa chỉ thành công");
			req.setAttribute("type", "success");
			req.getRequestDispatcher("/userInfo").forward(req, resp);

		}

	}

}
