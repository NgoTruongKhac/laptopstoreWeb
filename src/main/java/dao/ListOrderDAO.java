package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.Order;

public class ListOrderDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Order> listOrder;

	public ListOrderDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public List<Order> getListOrder(int page, int pageSize) {
		listOrder = new ArrayList<Order>();
		int offset = (page - 1) * pageSize;
		try {
			String query = "SELECT * FROM orders ORDER BY orderId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			PreparedStatement pr = conn.prepareStatement(query);

			pr.setInt(1, offset);
			pr.setInt(2, pageSize);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {

				Order order = new Order(rs.getInt("orderId"), rs.getInt("userId"), rs.getString("payment"),
						rs.getInt("totalPrice"), rs.getDate("orderDate"), rs.getString("state"));
				listOrder.add(order);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listOrder;
	}
	public int getTotalOrder() {
		int totalOrder = 0;
	    try {
	        String query = "SELECT COUNT(*) FROM orders";
	        PreparedStatement pr = conn.prepareStatement(query);
	        ResultSet rs = pr.executeQuery();
	        if (rs.next()) {
	            totalOrder = rs.getInt(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return totalOrder;
	}
}
