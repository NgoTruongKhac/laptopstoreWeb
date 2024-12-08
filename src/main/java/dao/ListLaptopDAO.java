package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.Laptop;

public class ListLaptopDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Laptop> listLaptop;

	public ListLaptopDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public List<Laptop> getListLaptop(int amount) {
		listLaptop = new ArrayList<Laptop>();
		try {

			String query = "SELECT p.productId, p.name, p.description, p.image, p.price, p.brand, \r\n"
					+ "       l.category, l.cpu, l.gpu, l.ram, l.drive, l.size, l.resolution \r\n"
					+ "FROM laptop l\r\n" + "JOIN product p ON l.productId = p.productId\r\n"
					+ "ORDER BY p.productId\r\n" + "OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY;\r\n";

			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, amount);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Laptop laptop = new Laptop(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("cpu"),
						rs.getString("gpu"), rs.getString("ram"), rs.getString("drive"), rs.getString("size"),
						rs.getString("resolution"));
				laptop.setLaptopId(rs.getInt("productId"));
				listLaptop.add(laptop);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listLaptop;
	}

	public List<Laptop> getListLaptopManage(int page, int pageSize) {
		listLaptop = new ArrayList<Laptop>();

		int offset = (page - 1) * pageSize;

		try {

			String query = "SELECT p.productId, p.name, p.description, p.image, p.price, p.brand, \r\n"
					+ "       l.category, l.cpu, l.gpu, l.ram, l.drive, l.size, l.resolution \r\n"
					+  "FROM laptop l\r\n" + "JOIN product p ON l.productId = p.productId\r\n"
					+ "ORDER BY p.productId\r\n" + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;\r\n";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, offset);
			pr.setInt(2, pageSize);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Laptop laptop = new Laptop(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("cpu"),
						rs.getString("gpu"), rs.getString("ram"), rs.getString("drive"), rs.getString("size"),
						rs.getString("resolution"));
				laptop.setLaptopId(rs.getInt("productId"));
				listLaptop.add(laptop);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listLaptop;
	}

	public int getTotalProductCount() {
		int totalProducts = 0;
		try {
			String query = "SELECT COUNT(*) FROM laptop";
			PreparedStatement pr = conn.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				totalProducts = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalProducts;
	}

}
