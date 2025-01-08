package dao.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectDatabase;

public class QuantityCartDAO {
	
	private Connection conn;
	private ConnectDatabase db;

	public QuantityCartDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}
	
	public int getCartCount(int userId) {
	    int cartCount = 0;
	    String query = "SELECT SUM(quantity) FROM cart WHERE userId = ?";
	    
	    try (PreparedStatement pr = conn.prepareStatement(query)) {
	        pr.setInt(1, userId);
	        ResultSet rs = pr.executeQuery();
	        
	        if (rs.next()) {
	            cartCount = rs.getInt(1);  // Lấy tổng số lượng sản phẩm trong giỏ hàng
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return cartCount;
	}
	

}
