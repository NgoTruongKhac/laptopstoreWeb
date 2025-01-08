package dao.my_order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import model.Order;

public class MyOrderDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Order> listOrder;

	public MyOrderDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
		listOrder = new ArrayList<Order>();
	}

	public List<Order> getMyOrder(int userId, int page, int pageSize) {
		int offset = (page - 1) * pageSize;
		try {
			String query = "SELECT * FROM orders where userId=? ORDER BY orderId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
			PreparedStatement pr = conn.prepareStatement(query);

			pr.setInt(1, userId);
			pr.setInt(2, offset);
			pr.setInt(3, pageSize);

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
	public int getTotalMyOrder(int userId) {
		
		int totalOrder = 0;
	    try {
	        String query = "SELECT COUNT(*) FROM orders where userId=?";
	        PreparedStatement pr = conn.prepareStatement(query);
	        pr.setInt(1, userId);
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
