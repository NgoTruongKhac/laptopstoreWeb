package dao.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import database.ConnectDatabase;
import model.Product;

public class ListProductCookieDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Product> listProduct;

	public ListProductCookieDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
		listProduct=new ArrayList<Product>();
	}

	public List<Product> getProductsByIds(List<Integer> productIds) {
		try {

			String query = "select p.productId, p.name, p.image,p.price, p.type from product p where productId IN ("
					+ productIds.stream().map(id -> "?").collect(Collectors.joining(",")) + ")";

			PreparedStatement pr = conn.prepareStatement(query);
			for (int i = 0; i < productIds.size(); i++) {
				pr.setInt(i + 1, productIds.get(i));
			}

			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				listProduct.add(new Product(rs.getInt("productId"), rs.getString("name"), rs.getString("image"),
						rs.getInt("price"), rs.getString("type")));

			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listProduct;
	}
}
