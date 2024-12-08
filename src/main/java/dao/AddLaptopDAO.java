package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import database.ConnectDatabase;
import entity.Laptop;

public class AddLaptopDAO {

	private Connection conn;
	private ConnectDatabase db;

	public AddLaptopDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean isAddLaptop(Laptop laptop) {
		boolean isSuccess = false;
		try {
			String productQuery = "INSERT INTO product (name, description, image, price, brand, type) VALUES (?, ?, ?, ?, ?, 'laptop');";
			    PreparedStatement productStmt = conn.prepareStatement(productQuery,Statement.RETURN_GENERATED_KEYS);

			    productStmt.setString(1, laptop.getName());
			    productStmt.setString(2, laptop.getDescription());
			    productStmt.setString(3, laptop.getImage());
			    productStmt.setInt(4, laptop.getPrice());
			    productStmt.setString(5, laptop.getBrand());
			    
			    int rowsInsertedProduct = productStmt.executeUpdate();
			    if (rowsInsertedProduct == 1) {
			        // Get the generated productId
			        ResultSet generatedKeys = productStmt.getGeneratedKeys();
			        if (generatedKeys.next()) {
			            int productId = generatedKeys.getInt(1); // Get the first generated key

			            // 2. Insert into laptop table
			            String laptopQuery = "INSERT INTO laptop (productId, category, cpu, gpu, ram, drive, size, resolution) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			            PreparedStatement laptopStmt = conn.prepareStatement(laptopQuery);

			            laptopStmt.setInt(1, productId);
			            laptopStmt.setString(2, laptop.getCategory());
			            laptopStmt.setString(3, laptop.getCpu());
			            laptopStmt.setString(4, laptop.getGpu());
			            laptopStmt.setString(5, laptop.getRam());
			            laptopStmt.setString(6, laptop.getDrive());
			            laptopStmt.setString(7, laptop.getSize());
			            laptopStmt.setString(8, laptop.getResolution());

			            int rowsInsertedLaptop = laptopStmt.executeUpdate();
			            
			            if (rowsInsertedLaptop == 1) {
			                isSuccess = true;
			            }
			        }
			    }

		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSuccess;
	}

}
