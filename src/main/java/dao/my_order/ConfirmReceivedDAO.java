package dao.my_order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectDatabase;

public class ConfirmReceivedDAO {
	private Connection conn;
	private ConnectDatabase db;

	public ConfirmReceivedDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}
	
	public boolean confirmReceived(int orderId) {
		boolean isSuccess = false;
		try {

			String query = "update orders set state=N'đã nhận' where orderId=?;";

			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, orderId);

			int i = pr.executeUpdate();
			if (i == 1) {
				isSuccess = true;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return isSuccess;

	}

}
