package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectDatabase;

public class DeleteCartItemDAO {
	
	private Connection conn;
	private ConnectDatabase db;

	public DeleteCartItemDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}
	
	public boolean isDeleteCartItem(int cartId) {
		boolean isSuccess=false;
		
		try {
			
			String query="delete from cart where cartId=?";
			PreparedStatement pr=conn.prepareStatement(query);
			
			pr.setInt(1, cartId);
			
			int i=pr.executeUpdate();
			
			if(i==1) {
				isSuccess=true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}

}
