package dao.my_order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import database.ConnectDatabase;
import model.CartItem;
import model.UserInfoOrder;

public class AddOrderDAO {

	private Connection conn;
	private ConnectDatabase db;

	public AddOrderDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean addOrderData(UserInfoOrder user, List<CartItem> listItem, String payment,int finalPrice) throws SQLException {
		boolean isSuccess = false;

		try {

			conn.setAutoCommit(false);
			// add table orders
			String query = "insert into orders (userId,payment,totalPrice) values(?,?,?)";

			PreparedStatement pr = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pr.setInt(1, user.getUserId());
			pr.setString(2, payment);
			pr.setInt(3, finalPrice);

			pr.executeUpdate();

			ResultSet rs = pr.getGeneratedKeys();
			int orderId = 0;
			if (rs.next()) {
				orderId = rs.getInt(1);
			}

			// add table orderInfo
			String query2 = "insert into orderInfo(orderId,userId,firstName,lastName,email,phoneNumber,province,district,ward,street,note) values (?,?,?,?,?,?,?,?,?,?,?); ";
			pr = conn.prepareStatement(query2);
			pr.setInt(1, orderId);
			pr.setInt(2, user.getUserId());
			pr.setString(3, user.getFirstName());
			pr.setString(4, user.getLastName());
			pr.setString(5, user.getEmail());
			pr.setString(6, user.getPhoneNumber());
			pr.setString(7, user.getProvince());
			pr.setString(8, user.getDistrict());
			pr.setString(9, user.getWard());
			pr.setString(10, user.getStreet());
			pr.setString(11, user.getNote());
			pr.executeUpdate();

			// add table orderDetail

			String query3 = "insert into orderDetail(orderId,productId,quantity) values (?,?,?) ";
			pr = conn.prepareStatement(query3);
			for (CartItem item : listItem) {
				pr.setInt(1, orderId);
				pr.setInt(2, item.getProductId());
				pr.setInt(3, item.getQuantity());
				pr.addBatch();
				;

			}
			pr.executeBatch();

			StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append("delete from cart where cartId in(");

			for (int i = 0; i < listItem.size(); i++) {
				queryBuilder.append("?");
				if (i < listItem.size() - 1) {
					queryBuilder.append(", ");
				}
			}
			queryBuilder.append(");");

			String query4 = queryBuilder.toString();
			pr = conn.prepareStatement(query4);

			for (int i = 0; i < listItem.size(); i++) {
				pr.setInt(i + 1, listItem.get(i).getCartId());

			}
			pr.executeUpdate();

			conn.commit();
			isSuccess = true;

		} catch (SQLException e) {
			// TODO: handle exception
			conn.rollback();
			e.printStackTrace();
		}

		return isSuccess;

	}

}
