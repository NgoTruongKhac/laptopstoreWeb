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
			String qery="select c.cartId, c.userId,c.productId,c.productType,c.quantity, CASE WHEN c.productType='laptop' THEN l.name WHEN c.productType='peripheral' THEN p.name END AS name,CASE WHEN c.productType='laptop' THEN l.image WHEN c.productType='peripheral' THEN p.image END AS image,CASE WHEN c.productType='laptop' THEN l.price WHEN c.productType='peripheral' THEN p.price END AS price from cart c LEFT JOIN laptop l ON c.productId = l.laptopId AND c.productType = 'laptop' LEFT JOIN peripheral p ON c.productId = p.peripheralId AND c.productType = 'peripheral' WHERE c.userId = ?;";
			
			PreparedStatement pr=conn.prepareStatement(qery);
			
			pr.setInt(1, userId);
			ResultSet rs=pr.executeQuery();
			
			while(rs.next()) {
				CartItem item=new CartItem(rs.getInt("cartId"),userId, rs.getInt("productId"), rs.getString("productType"), rs.getInt("quantity"),rs.getString("name"), rs.getString("image"),rs.getInt("price"));
				listCart.add(item);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
		}
		return listCart;
		
	}
	
	
}
