package servlet.detail_product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.admin.manage_product.EditLaptopDAO;
import dao.review.ListReviewDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Laptop;
import model.Review;

@WebServlet("/detailLaptop")

public class DetailLaptopServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int laptopId = Integer.parseInt(req.getParameter("productId"));

		EditLaptopDAO editlaptop = new EditLaptopDAO();

		Laptop laptop = editlaptop.getLaptop(laptopId);

		req.setAttribute("Laptop", laptop);

		ListReviewDAO lrd = new ListReviewDAO();

		List<Review> listReview = lrd.getListReview(laptopId);

		double rate = rate(listReview);
		Map<Integer, Integer> starStatistics = calculateStarStatistics(listReview);

		req.setAttribute("detailProduct", "/components/detailLaptop.jsp");
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
		if (count == 0) {
			return 0;
		}
		return (double) totalRate / count;
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
