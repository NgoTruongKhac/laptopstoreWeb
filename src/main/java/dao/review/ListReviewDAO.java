package dao.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import model.Review;

public class ListReviewDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Review> listReview;

	public ListReviewDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
		this.listReview = new ArrayList<Review>();
	}

	public List<Review> getListReview(int productId) {
		try {
			String query = "SELECT r.productId, r.userId, u.firstName, u.lastName, u.avatar, r.rate, r.comment, r.createdAt "
					+ "FROM reviews r " + "JOIN account u ON r.userId = u.userId " + "WHERE r.productId = ?";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, productId);

			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Review review = new Review(rs.getInt("productId"), rs.getInt("userId"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("avatar"), rs.getInt("rate"), rs.getString("comment"),rs.getDate("createdAt"));
				
				listReview.add(review);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listReview;
	}

}
