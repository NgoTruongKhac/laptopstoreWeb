package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectDatabase;
import entity.Address;

public class AddressDefaultDAO {

	private Connection conn;
	private ConnectDatabase db;
	private Address address;

	public AddressDefaultDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public Address getAddressDefault(int userId) {
		address = null;
		try {

			String query = "select * from address where userId=? and isDefault=1;";

			PreparedStatement pr = conn.prepareStatement(query);

			pr.setInt(1, userId);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				address = new Address(rs.getString("nameAddress"), rs.getString("province"), rs.getString("district"),
						rs.getString("ward"), rs.getString("street"), rs.getBoolean("isDefault"));
				address.setAddressId(rs.getInt("addressId"));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return address;

	}

}
