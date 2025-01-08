package servlet.home;

import java.io.IOException;
import java.util.List;

import dao.admin.manage_product.ListPeripheralDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Peripheral;

@WebServlet("/loadMorePeripheral")
public class LoadMorePeripheralServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int amount = Integer.parseInt(req.getParameter("peripheralExist"));
		ListPeripheralDAO listPeripheralDAO = new ListPeripheralDAO();
		List<Peripheral> listPeripheral = listPeripheralDAO.getListPeripheral(amount);

		req.setAttribute("ListPeripheral", listPeripheral);

		req.getRequestDispatcher("components/listPeripheral.jsp").forward(req, resp);
	}
}
