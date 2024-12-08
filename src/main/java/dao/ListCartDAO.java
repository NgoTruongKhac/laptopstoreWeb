package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.CartItem;

public class ListCartDAO {


	private Connection conn;
	private ConnectDatabase db;
	private List<CartItem> listCart;
	
	public ListCartDAO () {
		db=new ConnectDatabase();
		conn = db.getConnection();
	}
	
	public List<CartItem> getListCart(int userId){
		listCart=new ArrayList<CartItem>();
		try {
			String qery="select c.cartId, c.userId,c.productId,c.quantity, p.name,p.image,p.price, p.type from cart c join product p on c.productId=p.productId where c.userId=?;";
			
			PreparedStatement pr=conn.prepareStatement(qery);
			
			pr.setInt(1, userId);
			ResultSet rs=pr.executeQuery();
			
			while(rs.next()) {
				CartItem item=new CartItem(rs.getInt("cartId"),userId, rs.getInt("productId"), rs.getInt("quantity"),rs.getString("name"), rs.getString("image"),rs.getInt("price"));
				item.setType(rs.getString("type"));
				listCart.add(item);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
		}
		return listCart;
		
	}
	
	
}
