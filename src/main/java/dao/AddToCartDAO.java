package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectDatabase;
import entity.Cart;

public class AddToCartDAO {

	
	private Connection conn;
	private ConnectDatabase db;

	public AddToCartDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}
	
	public boolean isAddToCart(Cart cart) {
		boolean isSuccess=false;
		
		try {
			
			String query="insert into cart (userId,productId,productType,quantity) values (?,?,?,?)";
			PreparedStatement pr=conn.prepareStatement(query);
			
			pr.setInt(1, cart.getUserId());
			pr.setInt(2, cart.getProductId());
			pr.setString(3, cart.getProductType());
			pr.setInt(4, cart.getQuantity());
			
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
