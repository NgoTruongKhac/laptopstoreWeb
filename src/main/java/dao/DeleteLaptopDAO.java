package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.ConnectDatabase;

public class DeleteLaptopDAO {

	private Connection conn;
	private ConnectDatabase db;

	public DeleteLaptopDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean  deleteLaptop(int laptopId) {
		boolean isSuccess=false;
		try {
			String query = "delete from product where productId=?;";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, laptopId);
			
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
