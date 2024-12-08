package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectDatabase;
import entity.Peripheral;

public class EditPeripheralDAO {
	
	private Connection conn;
	private ConnectDatabase db;

	public EditPeripheralDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}
	
	public Peripheral getPeripheral(int peripheralId) {
		Peripheral peripheral=null;
		
		try {
			
			String query="SELECT p.productId, p.name, p.description, p.image, p.price, p.brand, \r\n"
					+ "       pe.category, pe.connect,pe.ledRGB \r\n"
					+  "FROM peripheral pe\r\n" + "JOIN product p ON pe.productId = p.productId\r\n"
					+ "where p.productId=? \r\n";
			PreparedStatement pr=conn.prepareStatement(query);
			pr.setInt(1, peripheralId);
			
			ResultSet rs=pr.executeQuery();
			
			while(rs.next()) {
				peripheral= new Peripheral(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("connect"),rs.getBoolean("ledRGB")
					 );
				peripheral.setPeripheralId(rs.getInt("productId"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return peripheral;
	}


}
