package servlet.detail_product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.admin.manage_product.EditPeripheralDAO;
import dao.review.ListReviewDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Peripheral;
import model.Review;

@WebServlet("/detailPeripheral")

public class DetailPeripheralServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int peripheralId=Integer.parseInt(req.getParameter("productId"));
		
		EditPeripheralDAO peripheralDao=new EditPeripheralDAO();
		
		Peripheral peripheral=peripheralDao.getPeripheral(peripheralId);
		
		
		
		ListReviewDAO lrd = new ListReviewDAO();

		List<Review> listReview = lrd.getListReview(peripheralId);

		double rate = rate(listReview);
		Map<Integer, Integer> starStatistics = calculateStarStatistics(listReview);

		
		req.setAttribute("Peripheral", peripheral);
		req.setAttribute("detailProduct", "/components/detailPeripheral.jsp");
		req.setAttribute("ListReview", listReview);
		req.setAttribute("rate", rate);
		req.setAttribute("StarStatistics", starStatistics);
		req.getRequestDispatcher("detailProduct.jsp").forward(req, resp);
		
	}
	private double rate(List<Review> listReview) {
		int totalRate = 0;
		int count = 0;
		for (Review r : listReview) {
			totalRate += r.getRate();
			count++;
		}
		return totalRate / count;
	}
	private Map<Integer, Integer> calculateStarStatistics(List<Review> listReview) {
	    Map<Integer, Integer> starStatistics = new HashMap<>();
	    for (int i = 1; i <= 5; i++) {
	        starStatistics.put(i, 0);
	    }
	    for (Review review : listReview) {
	        int rate = review.getRate();
	        starStatistics.put(rate, starStatistics.get(rate) + 1);
	    }
	    return starStatistics;
	}
	
	
	
	

}
