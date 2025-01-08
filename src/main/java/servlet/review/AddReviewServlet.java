package servlet.review;

import java.io.IOException;

import dao.review.AddReviewDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Review;
import model.User;

@WebServlet("/addReview")
@MultipartConfig
public class AddReviewServlet extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int rate=Integer.parseInt(req.getParameter("rating"));
		String[] productIds=req.getParameterValues("productId");
		
		int productId=0;
		for(String p: productIds) {
			if(!p.isEmpty()) {
				productId=Integer.parseInt(p);
			}
		}
		User user=(User) req.getSession().getAttribute("User");
		int userId=user.getUserId();
		String comment=req.getParameter("comment");
		
		Review review=new Review(productId, userId, rate, comment);
		
		AddReviewDAO addReview=new AddReviewDAO();
		boolean isSuccess=addReview.addReview(review);
		
		if(isSuccess) {
			
			resp.sendRedirect(req.getContextPath() + "/listReview?productId="+productId);
		}
		
	}
	
	
	
	

}
