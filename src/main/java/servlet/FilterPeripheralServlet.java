package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.FilterPeripheralDAO;
import entity.Peripheral;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/filterPeripheral")
public class FilterPeripheralServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Map<String, List<String>> filters = new HashMap<String, List<String>>();

		String[] categoryFilters = req.getParameterValues("category");
		String[] connectFilters = req.getParameterValues("connect");
		String[] ledFilters = req.getParameterValues("ledRGB");
		String[] brandFilters = req.getParameterValues("brand");

		int priceFrom = Integer.parseInt(req.getParameter("from"));
		int priceTo = Integer.parseInt(req.getParameter("to"));
		String title = req.getParameter("title");

		if (categoryFilters != null) {
			filters.put("category", Arrays.asList(categoryFilters));
		}
		if (connectFilters != null) {
			filters.put("connect", Arrays.asList(connectFilters));
		}
		if (ledFilters != null) {
			filters.put("ledRGB", Arrays.asList(ledFilters));
		}
		if (brandFilters != null) {
			filters.put("brand", Arrays.asList(brandFilters));
		}

		FilterPeripheralDAO filterDao = new FilterPeripheralDAO();

		List<Peripheral> listPeripheral = filterDao.getListPeripheral(filters, priceFrom, priceTo);

		req.setAttribute("ListPeripheral", listPeripheral);
		req.setAttribute("title", title);
		req.setAttribute("filterProduct", "components/listPeripheral.jsp");
		req.getRequestDispatcher("filterProduct.jsp").forward(req, resp);

	}

}
