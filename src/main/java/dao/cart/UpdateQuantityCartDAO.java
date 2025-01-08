package dao.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.ConnectDatabase;

public class UpdateQuantityCartDAO {
	
	private Connection conn;
	private ConnectDatabase db;

	public UpdateQuantityCartDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}
	
	
	public void setQuantityCart(int cartId, int quantity) {
		try {
			String query="update cart set quantity=? where cartId=?;";
			PreparedStatement pr=conn.prepareStatement(query);
			
			pr.setInt(1, quantity);
			pr.setInt(2, cartId);
			
			pr.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
