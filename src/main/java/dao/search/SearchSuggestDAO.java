package dao.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import model.Product;

public class SearchSuggestDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Product> listProduct;

	public SearchSuggestDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
		this.listProduct = new ArrayList<Product>();
	}

	public List<Product> getListSearchSuggest(String searchText) {

		try {

			String query = "select p.productId, p.name, p.image,p.price, p.type from product p where name like ?";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setString(1, "%" + searchText + "%");

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
