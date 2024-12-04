package servlet;

import java.io.IOException;
import java.util.List;

import dao.ListLaptopDAO;
import dao.ListPeripheralDAO;
import entity.Laptop;
import entity.Peripheral;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loadMorePeripheral")
public class LoadMorePeripheralServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int amount = Integer.parseInt(req.getParameter("peripheralExist"));
		ListPeripheralDAO listPeripheralDAO = new ListPeripheralDAO();
		List<Peripheral> listPeripheral = listPeripheralDAO.getListPeripheral(amount);

		req.setAttribute("ListPeripheral", listPeripheral);

		req.getRequestDispatcher("components/listPeripheral.jsp").forward(req, resp);
	}
}
