package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.CartItem;


public class BuyNowDAO {

	private Connection conn;
	private ConnectDatabase db;

	public BuyNowDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public List<CartItem> getItem(int productId) {
		List<CartItem> listItem = new ArrayList<CartItem>();

		try {

			String query = "select productId,name,image,price from product where productId=?;";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, productId);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {

				CartItem item = new CartItem(rs.getInt("productId"),
						1, rs.getString("name"), rs.getString("image"), rs.getInt("price"));
				listItem.add(item);

			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listItem;

	}
}
