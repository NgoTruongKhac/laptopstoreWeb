package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

			String qery = "insert into peripheral (name,description,image,price,brand,category,connect,ledRGB) values(?,?,?,?,?,?,?,?); ";
			PreparedStatement pr = conn.prepareStatement(qery);

			pr.setString(1, peripheral.getName());
			pr.setString(2, peripheral.getDescription());
			pr.setString(3, peripheral.getImage());
			pr.setInt(4, peripheral.getPrice());
			pr.setString(5, peripheral.getBrand());
			pr.setString(6, peripheral.getCategory());
			pr.setString(7, peripheral.getConnect());
			pr.setBoolean(8, peripheral.isLedRGB());

			int i = pr.executeUpdate();

			if (i == 1) {
				isSuccess = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSuccess;
	}

}
