package servlet.admin.manage_product;

import java.io.IOException;

import dao.admin.manage_product.DeletePeripheralDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminPage/deletePeripheral")
public class DeletePeripheralServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int peripheralId = Integer.parseInt(req.getParameter("peripheralId"));
		int pagePeripheral = Integer.parseInt(req.getParameter("pagePeripheral"));

		DeletePeripheralDAO deletePeripheral = new DeletePeripheralDAO();

		boolean isSuccess = deletePeripheral.deletePeripheral(peripheralId);

		if (isSuccess) {

			resp.sendRedirect(req.getContextPath() + "/adminPage/listPeripheral?pagePeripheral=" + pagePeripheral);

		}
	}

}
