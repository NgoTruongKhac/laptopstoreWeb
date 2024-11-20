package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectDatabase;
import entity.Laptop;

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

			String query = "select * from laptop where laptopId=?";
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
