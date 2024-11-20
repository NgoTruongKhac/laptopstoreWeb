package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.ConnectDatabase;
import entity.Laptop;

public class UpdateLaptopDAO {

	private Connection conn;
	private ConnectDatabase db;

	public UpdateLaptopDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean isUpdateLaptop(Laptop laptop) {
		boolean isSuccess = false;

		try {

			String query = "update laptop set name=?,description=?,image=?,price=?,brand=?,category=?,cpu=?,gpu=?,ram=?,drive=?,size=?,resolution=? where laptopId=?;";

			PreparedStatement pr = conn.prepareStatement(query);

			pr.setString(1, laptop.getName());
			pr.setString(2, laptop.getDescription());
			pr.setString(3, laptop.getImage());
			pr.setInt(4, laptop.getPrice());
			pr.setString(5, laptop.getBrand());
			pr.setString(6, laptop.getCategory());
			pr.setString(7, laptop.getCpu());
			pr.setString(8, laptop.getGpu());
			pr.setString(9, laptop.getRam());
			pr.setString(10, laptop.getRam());
			pr.setString(11, laptop.getDrive());
			pr.setString(12, laptop.getResolution());
			pr.setInt(13, laptop.getLaptopId());

			int i = pr.executeUpdate();

			if (i == 1) {
				isSuccess = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;

	}

}
