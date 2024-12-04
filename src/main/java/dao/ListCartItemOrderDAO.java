package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.CartItem;

public class ListCartItemOrderDAO {
	
	private Connection conn;
	private ConnectDatabase db;
	private List<CartItem> listCartItem;
	
	public ListCartItemOrderDAO () {
		db=new ConnectDatabase();
		conn = db.getConnection();
	}
	public List<CartItem> listCartItemOrder(String[] listCartId){
		listCartItem=new ArrayList<CartItem>();
		
		try {
			 StringBuilder queryBuilder = new StringBuilder();
			 queryBuilder.append(
			            "SELECT c.cartId, c.userId, c.productId, c.productType, c.quantity, "
			            + "CASE WHEN c.productType = 'laptop' THEN l.name "
			            + "     WHEN c.productType = 'peripheral' THEN p.name END AS name, "
			            + "CASE WHEN c.productType = 'laptop' THEN l.image "
			            + "     WHEN c.productType = 'peripheral' THEN p.image END AS image, "
			            + "CASE WHEN c.productType = 'laptop' THEN l.price "
			            + "     WHEN c.productType = 'peripheral' THEN p.price END AS price "
			            + "FROM cart c "
			            + "LEFT JOIN laptop l ON c.productId = l.laptopId AND c.productType = 'laptop' "
			            + "LEFT JOIN peripheral p ON c.productId = p.peripheralId AND c.productType = 'peripheral' "
			            + "WHERE c.cartId IN ("
			        );
			 
			 for (int i = 0; i < listCartId.length; i++) {
		            queryBuilder.append("?");
		            if (i < listCartId.length - 1) {
		                queryBuilder.append(", ");
		            }
		        }
		        queryBuilder.append(");");

		        String query = queryBuilder.toString();
		        
		        PreparedStatement pr=conn.prepareStatement(query);
		        
		        for (int i = 0; i < listCartId.length; i++) {
	                pr.setString(i + 1, listCartId[i]);
	            }
		        
		        ResultSet rs=pr.executeQuery();
		        
		        while(rs.next()) {
					CartItem item=new CartItem(rs.getInt("cartId"),rs.getInt("userId"), rs.getInt("productId"), rs.getString("productType"), rs.getInt("quantity"),rs.getString("name"), rs.getString("image"),rs.getInt("price"));
					listCartItem.add(item);
				}
		        
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listCartItem;
		
		
	}

}
