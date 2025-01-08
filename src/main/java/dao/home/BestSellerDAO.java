package dao.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import model.Laptop;

public class BestSellerDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Laptop> bestSeller;

	public BestSellerDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public List<Laptop> getBestSeller() {
		bestSeller = new ArrayList<Laptop>();
		try {
			
			String query = "SELECT TOP 10 p.productId, p.name, p.description, p.image, p.price, p.brand, "
		             + "       l.category, l.cpu, l.gpu, l.ram, l.drive, l.size, l.resolution, "
		             + "       COUNT(r.reviewId) AS quantityReview, "
		             + "       COALESCE(AVG(r.rate), 0) AS avgRate "
		             + "FROM laptop l "
		             + "JOIN product p ON l.productId = p.productId "
		             + "LEFT JOIN reviews r ON r.productId = p.productId "
		             + "GROUP BY p.productId, p.name, p.description, p.image, p.price, p.brand, "
		             + "         l.category, l.cpu, l.gpu, l.ram, l.drive, l.size, l.resolution "
		             + "ORDER BY p.productId;";

			PreparedStatement pr = conn.prepareStatement(query);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Laptop laptop = new Laptop(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("cpu"),
						rs.getString("gpu"), rs.getString("ram"), rs.getString("drive"), rs.getString("size"),
						rs.getString("resolution"));
				laptop.setLaptopId(rs.getInt("productId"));
				laptop.setRate(rs.getDouble("avgRate"));
				laptop.setQuantityReview(rs.getInt("quantityReview"));
				bestSeller.add(laptop);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bestSeller;
	}
}
