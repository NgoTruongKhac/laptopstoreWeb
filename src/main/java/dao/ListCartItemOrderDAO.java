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

	public ListCartItemOrderDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public List<CartItem> listCartItemOrder(String[] listCartId) {
		listCartItem = new ArrayList<CartItem>();

		try {
			StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append(
					"select c.cartId, c.userId,c.productId,c.quantity, p.name,p.image,p.price from cart c join product p on c.productId=p.productId "
							+ "WHERE c.cartId IN (");

			for (int i = 0; i < listCartId.length; i++) {
				queryBuilder.append("?");
				if (i < listCartId.length - 1) {
					queryBuilder.append(", ");
				}
			}
			queryBuilder.append(");");

			String query = queryBuilder.toString();

			PreparedStatement pr = conn.prepareStatement(query);

			for (int i = 0; i < listCartId.length; i++) {
				pr.setString(i + 1, listCartId[i]);
			}

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				CartItem item = new CartItem(rs.getInt("cartId"), rs.getInt("userId"), rs.getInt("productId"),
						rs.getInt("quantity"), rs.getString("name"), rs.getString("image"), rs.getInt("price"));
				listCartItem.add(item);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listCartItem;

	}

}
