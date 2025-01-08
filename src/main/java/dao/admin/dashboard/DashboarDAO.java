package dao.admin.dashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectDatabase;
import model.Dashboard;

public class DashboarDAO {
	private Connection conn;
	private ConnectDatabase db;

	public DashboarDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public Dashboard getDashboard() {
		int quantityUser = getCount("account");
		int quantityProduct = getCount("product");
		int quantityOrder = getCount("orders");

		return new Dashboard(quantityUser, quantityProduct, quantityOrder);
	}

	private int getCount(String tableName) {
	    int count = 0;
	    String query = "SELECT COUNT(*) FROM " + tableName;
	    try (PreparedStatement pr = conn.prepareStatement(query);
	         ResultSet rs = pr.executeQuery()) {
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}


}
