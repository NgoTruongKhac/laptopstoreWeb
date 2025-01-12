package servlet.admin.manage_product;

import java.io.IOException;

import dao.admin.manage_product.EditPeripheralDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Peripheral;

@WebServlet("/adminPage/editPeripheral")
public class EditPeripheralServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int peripheralId = Integer.parseInt(req.getParameter("peripheralId"));
		int pagePeripheral=Integer.parseInt(req.getParameter("pagePeripheral"));
		
		EditPeripheralDAO editPeripheral = new EditPeripheralDAO();
		Peripheral peripheral= editPeripheral.getPeripheral(peripheralId);
		
		

		req.setAttribute("Peripheral", peripheral);
		req.setAttribute("pagePeripheral", pagePeripheral);

		req.getRequestDispatcher("/componentsAdmin/editPeripheral.jsp").forward(req, resp);

	}

}
