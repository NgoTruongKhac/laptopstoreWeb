package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.FilterProductDAO;
import entity.Laptop;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/filterLaptop")
public class FilterLaptopServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, List<String>> filters = new HashMap<String, List<String>>();

		String[] cpuFilters = req.getParameterValues("cpu");
		String[] gpuFilters = req.getParameterValues("gpu");
		String[] ramFilters = req.getParameterValues("ram");
		String[] driveFilters = req.getParameterValues("drive");
		String[] sizeFilters = req.getParameterValues("size");
		String[] brandFilters = req.getParameterValues("brand");
		String[] resolutionFilters = req.getParameterValues("resolution");
		String[] categoryFilters = req.getParameterValues("category");
		int priceFrom=Integer.parseInt(req.getParameter("from"));
		int priceTo=Integer.parseInt(req.getParameter("to"));
		String title=req.getParameter("title");
		

		if (cpuFilters != null) {
			filters.put("cpu", Arrays.asList(cpuFilters));
		}
		if (gpuFilters != null) {
			filters.put("gpu", Arrays.asList(gpuFilters));
		}
		if (brandFilters != null) {
			filters.put("brand", Arrays.asList(brandFilters));
		}
		if (driveFilters != null) {
			filters.put("drive", Arrays.asList(driveFilters));
		}
		if (ramFilters != null) {
			filters.put("ram", Arrays.asList(ramFilters));
		}
		if (sizeFilters != null) {
			filters.put("size", Arrays.asList(sizeFilters));
		}
		if (resolutionFilters != null) {
			filters.put("resolution", Arrays.asList(resolutionFilters));
		}
		if (categoryFilters != null) {
			filters.put("category", Arrays.asList(categoryFilters));
		}
	
		
		
		FilterProductDAO filterDao=new FilterProductDAO();
		
		List<Laptop> listLaptop=filterDao.getListLaptop(filters,priceFrom, priceTo);
	
		
		req.setAttribute("ListLaptop", listLaptop);
		req.setAttribute("title", title);
		req.setAttribute("filterProduct", "components/listLaptop.jsp");
		req.getRequestDispatcher("filterProduct.jsp").forward(req, resp);
		
		
		

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	

}
