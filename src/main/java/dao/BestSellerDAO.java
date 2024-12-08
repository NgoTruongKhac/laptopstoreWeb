package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.Laptop;

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

			String query =  "SELECT top 10 p.productId, p.name, p.description, p.image, p.price, p.brand, \r\n"
					+ "       l.category, l.cpu, l.gpu, l.ram, l.drive, l.size, l.resolution \r\n"
					+  "FROM laptop l\r\n" + "JOIN product p ON l.productId = p.productId\r\n"
					+ "ORDER BY p.productId\r\n";
			PreparedStatement pr = conn.prepareStatement(query);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Laptop laptop = new Laptop(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("cpu"),
						rs.getString("gpu"), rs.getString("ram"), rs.getString("drive"), rs.getString("size"),
						rs.getString("resolution"));
				laptop.setLaptopId(rs.getInt("productId"));
				bestSeller.add(laptop);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bestSeller;
	}
}
