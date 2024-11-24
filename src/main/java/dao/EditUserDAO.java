package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectDatabase;
import entity.User;

public class EditUserDAO {

	
	private Connection conn;
	private ConnectDatabase db;

	public EditUserDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}
	
	
	public User getUser(int userId) {
		User user=null;
		try {
			String query="select * from account where userId=?;";
			
			PreparedStatement pr=conn.prepareStatement(query);
			
			pr.setInt(1, userId);
			
			ResultSet rs=pr.executeQuery();
			
			while(rs.next()) {
				user=new User(rs.getString("firstName"), rs.getString("lastName"), "", rs.getString("email"), rs.getString("phoneNumber"));
				user.setUserId(rs.getInt("userId"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getDate("birthday"));
				user.setAvatar(rs.getString("avatar"));
				user.setRole(rs.getString("role"));
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}
}
