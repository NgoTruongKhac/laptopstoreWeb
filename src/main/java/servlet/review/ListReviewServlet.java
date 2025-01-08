package servlet.review;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.review.ListReviewDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Review;


@WebServlet("/listReview")
public class ListReviewServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int prouductId = Integer.parseInt(req.getParameter("productId"));
		
		ListReviewDAO lrd = new ListReviewDAO();

		List<Review> listReview = lrd.getListReview(prouductId);

		double rate = rate(listReview);
		Map<Integer, Integer> starStatistics = calculateStarStatistics(listReview);
		

		req.setAttribute("ListReview", listReview);
		req.setAttribute("rate", rate);
		req.setAttribute("StarStatistics", starStatistics);

		req.getRequestDispatcher("components/listReview.jsp").forward(req, resp);
		
		
	}
	private double rate(List<Review> listReview) {
	    if (listReview.isEmpty()) {
	        return 0.0; // Nếu không có review, trả về 0
	    }
	    
	    int totalRate = 0;
	    for (Review r : listReview) {
	        totalRate += r.getRate();
	    }
	    return (double) totalRate / listReview.size(); // Chia cho số lượng review
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
