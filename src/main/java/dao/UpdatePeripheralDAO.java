package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.ConnectDatabase;
import entity.Peripheral;

public class UpdatePeripheralDAO {

	private Connection conn;
	private ConnectDatabase db;

	public UpdatePeripheralDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean isUpdatePeripheral(Peripheral peripheral) {
		boolean isSuccess = false;
		try {
			String productQuery = "UPDATE product SET name = ?, description = ?, image = ?, price = ?, brand = ? WHERE productId = ?;";
			PreparedStatement productStmt = conn.prepareStatement(productQuery);

			productStmt.setString(1, peripheral.getName());
			productStmt.setString(2, peripheral.getDescription());
			productStmt.setString(3, peripheral.getImage());
			productStmt.setInt(4, peripheral.getPrice());
			productStmt.setString(5, peripheral.getBrand());
			productStmt.setInt(6, peripheral.getPeripheralId()); // Sử dụng peripheralId để tìm productId

			int rowsUpdatedProduct = productStmt.executeUpdate();

			if (rowsUpdatedProduct == 1) {
				// 2. Cập nhật bảng peripheral
				String peripheralQuery = "UPDATE peripheral SET category = ?, connect = ?, ledRGB = ? WHERE productId = ?;";
				PreparedStatement peripheralStmt = conn.prepareStatement(peripheralQuery);

				peripheralStmt.setString(1, peripheral.getCategory());
				peripheralStmt.setString(2, peripheral.getConnect());
				peripheralStmt.setBoolean(3, peripheral.isLedRGB());
				peripheralStmt.setInt(4, peripheral.getPeripheralId());

				int rowsUpdatedPeripheral = peripheralStmt.executeUpdate();

				if (rowsUpdatedPeripheral == 1) {
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
