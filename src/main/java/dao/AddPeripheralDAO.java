package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import database.ConnectDatabase;
import entity.Peripheral;

public class AddPeripheralDAO {

	private Connection conn;
	private ConnectDatabase db;

	public AddPeripheralDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean isAddPeripheral(Peripheral peripheral) {
		boolean isSuccess = false;
		try {

		    String productQuery = "INSERT INTO product (name, description, image, price, brand, type) VALUES (?, ?, ?, ?, ?, 'peripheral');";
		    PreparedStatement productStmt = conn.prepareStatement(productQuery, Statement.RETURN_GENERATED_KEYS);

		    productStmt.setString(1, peripheral.getName());
		    productStmt.setString(2, peripheral.getDescription());
		    productStmt.setString(3, peripheral.getImage());
		    productStmt.setInt(4, peripheral.getPrice());
		    productStmt.setString(5, peripheral.getBrand());

		    int rowsInsertedProduct = productStmt.executeUpdate();
		    if (rowsInsertedProduct == 1) {
		        // Get the generated productId
		        ResultSet generatedKeys = productStmt.getGeneratedKeys();
		        if (generatedKeys.next()) {
		            int productId = generatedKeys.getInt(1); // Lấy productId được sinh tự động

		            // 2. Insert vào bảng peripheral
		            String peripheralQuery = "INSERT INTO peripheral (productId, category, connect, ledRGB) VALUES (?, ?, ?, ?);";
		            PreparedStatement peripheralStmt = conn.prepareStatement(peripheralQuery);

		            peripheralStmt.setInt(1, productId);
		            peripheralStmt.setString(2, peripheral.getCategory());
		            peripheralStmt.setString(3, peripheral.getConnect());
		            peripheralStmt.setBoolean(4, peripheral.isLedRGB());

		            int rowsInsertedPeripheral = peripheralStmt.executeUpdate();

		            if (rowsInsertedPeripheral == 1) {
		                isSuccess = true; // Thành công khi cả hai bảng được thêm dữ liệu
		            }
		        }
		    }
		        
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSuccess;
	}

}
