package dao.admin.manage_product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectDatabase;
import model.Laptop;

public class EditLaptopDAO {

	private Connection conn;
	private ConnectDatabase db;

	public EditLaptopDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public Laptop getLaptop(int laptopId) {
		Laptop laptop = null;

		try {

			String query = "SELECT p.productId, p.name, p.description, p.image, p.price, p.brand, \r\n"
					+ "       l.category, l.cpu, l.gpu, l.ram, l.drive, l.size, l.resolution \r\n"
					+ "FROM laptop l\r\n" + "JOIN product p ON l.productId = p.productId\r\n"
					+ "where p.productId=?\r\n";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, laptopId);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				laptop = new Laptop(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("cpu"),
						rs.getString("gpu"), rs.getString("ram"), rs.getString("drive"), rs.getString("size"),
						rs.getString("resolution"));
				laptop.setLaptopId(laptopId);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return laptop;
	}

}
