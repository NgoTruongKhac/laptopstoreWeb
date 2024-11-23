package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectDatabase;
import entity.User;

public class RegisterDAO {

	private Connection conn;
	private ConnectDatabase db;
	
	public RegisterDAO() {
		db=new ConnectDatabase();
		conn=db.getConnection();
	}

	public boolean isSuccess(String emailOrPhone) {
		// TODO Auto-generated method stub
		boolean isRegister = true;

		try {
		

			String insertSQL = "  select * from account where email=? or phoneNumber=?;";
			PreparedStatement pr = conn.prepareStatement(insertSQL);
			
			pr.setString(1, emailOrPhone);
			pr.setString(2, emailOrPhone);
		
			ResultSet rs=pr.executeQuery();

			if(rs.next()) {
				isRegister=false;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return isRegister;
	}
	
	public boolean verifyCode(User user) {
		boolean isVerified = false;

		try {
			String verifySQL = "INSERT INTO account(firstName,lastName, pass, email, phoneNumber) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement pr = conn.prepareStatement(verifySQL);		
			pr.setString(1, user.getFirstName());
			pr.setString(2, user.getLastName());
			pr.setString(3, user.getPass());
			pr.setString(4, user.getEmail());
			pr.setString(5, user.getPhoneNumber());

			int i = pr.executeUpdate();

			if (i == 1) {
				isVerified = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isVerified;
	}


}
