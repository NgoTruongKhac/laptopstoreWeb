package servlet;

import java.io.IOException;
import java.util.List;

import dao.SearchSuggestDAO;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchSuggest")
public class SearchSuggestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String searText = req.getParameter("searchText");

		SearchSuggestDAO ssd = new SearchSuggestDAO();

		List<Product> listProductSuggest = ssd.getListSearchSuggest(searText);
		if (listProductSuggest.isEmpty()) {
			req.setAttribute("noResultMessage", "Không tìm thấy sản phẩm phù hợp.");
		}
		req.setAttribute("ListProductSuggest", listProductSuggest);

		req.getRequestDispatcher("/components/searchSuggest.jsp").forward(req, resp);

	}

}
