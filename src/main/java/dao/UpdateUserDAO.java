package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.ConnectDatabase;
import entity.User;

public class UpdateUserDAO {
	
	private Connection conn;
	private ConnectDatabase db;

	public UpdateUserDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}
	
	public boolean isUpdateUser(User user) {
		boolean isSuccess=false;
		
		try {
			
			String query="update account set firstName=?,lastName=?,email=?,phoneNumber=?, sex=?, birthday=?, avatar=?,role=? where userId=?;";
			PreparedStatement pr=conn.prepareStatement(query);
			pr.setString(1, user.getFirstName());
			pr.setString(2, user.getLastName());
			pr.setString(3, user.getEmail());
			pr.setString(4, user.getPhoneNumber());
			pr.setString(5, user.getSex());
			pr.setDate(6, user.getBirthday());
			pr.setString(7, user.getAvatar());
			pr.setString(8, user.getRole());
			pr.setInt(9, user.getUserId());
			
			int i=pr.executeUpdate();
			
			if(i==1) {
				isSuccess=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return isSuccess;
	}

}
