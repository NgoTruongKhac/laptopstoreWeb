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
			
			String query="select * from peripheral where peripheralId=?;";
			PreparedStatement pr=conn.prepareStatement(query);
			pr.setInt(1, peripheralId);
			
			ResultSet rs=pr.executeQuery();
			
			while(rs.next()) {
				peripheral= new Peripheral(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("connect"),rs.getBoolean("ledRGB")
					 );
				peripheral.setPeripheralId(rs.getInt("peripheralId"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return peripheral;
	}


}
