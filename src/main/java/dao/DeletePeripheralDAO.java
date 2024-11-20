package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.ConnectDatabase;

public class DeletePeripheralDAO {

	private Connection conn;
	private ConnectDatabase db;

	public DeletePeripheralDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean deletePeripheral(int peripheralId) {
		boolean isSuccess = false;
		try {
			String query = "delete from peripheral where peripheralId=?;";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, peripheralId);

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
