package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectDatabase;
import entity.User;

public class AddUserDAO {

	private Connection conn;
	private ConnectDatabase db;

	public AddUserDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean isAddUser(User user) throws SQLException {
		boolean isSuccess = false;
		try {

			String query = "insert into account(firstName,lastName, pass,email,phoneNumber,sex,birthday,avatar,role) values (?,?,?,?,?,?,?,?,?);";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setString(1, user.getFirstName());
			pr.setString(2, user.getLastName());
			pr.setString(3, user.getPass());
			pr.setString(4, user.getEmail());
			pr.setString(5, user.getPhoneNumber());
			pr.setString(6, user.getSex());
			pr.setDate(7, user.getBirthday());
			pr.setString(8, user.getAvatar());
			pr.setString(9, user.getRole());

			int i = pr.executeUpdate();
			if (i == 1) {
				isSuccess = true;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			if (e.getMessage().contains("email")) {
				throw new SQLException("Email already exists", e);
			} else if (e.getMessage().contains("phoneNumber")) {
				throw new SQLException("Phone number already exists", e);
			}
		}

		return isSuccess;

	}

}
