package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.OrderDetail;
import entity.UserInfoOrder;

public class OrderDetailDAO {

	private Connection conn;
	private ConnectDatabase db;

	private List<OrderDetail> listOrderDetail;

	public OrderDetailDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public List<OrderDetail> getListOrderDetail(int orderId) {

		listOrderDetail = new ArrayList<OrderDetail>();
		try {

			String query = "select o.orderId, o.productId, p.name,p.image,p.price, o.quantity from orderDetail o join product p on o.productId=p.productId where o.orderId=?";
			PreparedStatement pr = conn.prepareStatement(query);

			pr.setInt(1, orderId);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				OrderDetail orderDetail = new OrderDetail(rs.getInt("orderId"), rs.getInt("productId"),
						rs.getString("name"), rs.getString("image"), rs.getInt("price"), rs.getInt("quantity"));
				listOrderDetail.add(orderDetail);

			}

		} catch (SQLException e) {

			// TODO: handle exception
			e.printStackTrace();
		}

		return listOrderDetail;

	}
	public UserInfoOrder getUserInfoOrder(int orderId) {
		UserInfoOrder userInfo=null;
		try {
			
			String query="select * from orderInfo where orderId=?";
			PreparedStatement pr=conn.prepareStatement(query);
			pr.setInt(1, orderId);
			
			
			ResultSet rs=pr.executeQuery();
			
			while(rs.next()) {
				
				userInfo=new UserInfoOrder(rs.getInt("userId"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getString("phoneNumber"), rs.getString("province"), rs.getString("district"), rs.getString("ward"), rs.getString("street"), rs.getString("note"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return userInfo;
	}
	

}
