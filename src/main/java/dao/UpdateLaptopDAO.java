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

			String productQuery = "UPDATE product SET name = ?, description = ?, image = ?, price = ?, brand = ? WHERE productId =?;";
			PreparedStatement productStmt = conn.prepareStatement(productQuery);

			productStmt.setString(1, laptop.getName());
			productStmt.setString(2, laptop.getDescription());
			productStmt.setString(3, laptop.getImage());
			productStmt.setInt(4, laptop.getPrice());
			productStmt.setString(5, laptop.getBrand());
			productStmt.setInt(6, laptop.getLaptopId()); // Sử dụng laptopId để tìm productId

			int rowsUpdatedProduct = productStmt.executeUpdate();

			if (rowsUpdatedProduct == 1) {
				// 2. Cập nhật bảng laptop
				String laptopQuery = "UPDATE laptop SET category = ?, cpu = ?, gpu = ?, ram = ?, drive = ?, size = ?, resolution = ? WHERE productId = ?;";
				PreparedStatement laptopStmt = conn.prepareStatement(laptopQuery);

				laptopStmt.setString(1, laptop.getCategory());
				laptopStmt.setString(2, laptop.getCpu());
				laptopStmt.setString(3, laptop.getGpu());
				laptopStmt.setString(4, laptop.getRam());
				laptopStmt.setString(5, laptop.getDrive());
				laptopStmt.setString(6, laptop.getSize());
				laptopStmt.setString(7, laptop.getResolution());
				laptopStmt.setInt(8, laptop.getLaptopId());

				int rowsUpdatedLaptop = laptopStmt.executeUpdate();

				if (rowsUpdatedLaptop == 1) {
					isSuccess = true; // Thành công khi cả hai bảng được cập nhật
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;

	}

}
