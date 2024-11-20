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
		boolean isSuccess=false;
		try {
			String query="update peripheral set name=?,description=?,image=?,price=?,brand=?,category=?,connect=?,ledRGB=? where peripheralId=?";
			PreparedStatement pr=conn.prepareStatement(query);
			
			pr.setString(1, peripheral.getName());
			pr.setString(2, peripheral.getDescription());
			pr.setString(3, peripheral.getImage());
			pr.setInt(4, peripheral.getPrice());
			pr.setString(5, peripheral.getBrand());
			pr.setString(6, peripheral.getCategory());
			pr.setString(7, peripheral.getConnect());
			pr.setBoolean(8, peripheral.isLedRGB());
			pr.setInt(9, peripheral.getPeripheralId());
			
			int i=pr.executeUpdate();
			
			if(i==1) {
				isSuccess=true;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;
	}


}
