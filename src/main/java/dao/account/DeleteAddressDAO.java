package dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.ConnectDatabase;

public class DeleteAddressDAO {

	private Connection conn;
	private ConnectDatabase db;

	public DeleteAddressDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean deleteAdress(int addressId) {
		boolean isSuccess = false;
		try {
			String query = "delete from address where addressId=?;";
			PreparedStatement pr = conn.prepareStatement(query);

			pr.setInt(1, addressId);

			int i = pr.executeUpdate();
			if (i == 1) {
				isSuccess = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;
	}

}
