package dao.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectDatabase;
import model.Review;

public class AddReviewDAO {
	
	private Connection conn;
	private ConnectDatabase db;

	public AddReviewDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}
	
	
	public boolean addReview(Review review) {
		boolean isSuccess=false;
		
		try {
			
			String query="insert into reviews (productId,userId,rate,comment) values (?,?,?,?);";
			PreparedStatement pr=conn.prepareStatement(query);
			
			pr.setInt(1, review.getProductId());
			pr.setInt(2, review.getUserId());
			pr.setInt(3, review.getRate());
			pr.setString(4, review.getComment());
			
			
			int i=pr.executeUpdate();
			
			if(i==1) {
				isSuccess=true;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return isSuccess;
		
		
	}

}
