package dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.ConnectDatabase;
import model.User;

public class UpdateUserInfoDAO {
	
	private Connection conn;
	private ConnectDatabase db;
	
	public UpdateUserInfoDAO() {
		db=new ConnectDatabase();
		conn=db.getConnection();
	}
	
	public boolean isUpdate(User userUpdate, int userId) {
		boolean isUpdate=false;
		
		try {
			
			String sql="UPDATE account SET firstName=?,lastName=?, sex=?, birthday=?, avatar=?, phoneNumber=? where userId=?;"; 
			
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, userUpdate.getFirstName());
			pr.setString(2, userUpdate.getLastName());
			pr.setString(3, userUpdate.getSex());
			pr.setDate(4, userUpdate.getBirthday());
			pr.setString(5, userUpdate.getAvatar());
			pr.setString(6, userUpdate.getPhoneNumber());
			pr.setInt(7, userId);
			
			int i=pr.executeUpdate();
			
			if(i==1) {
				isUpdate=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isUpdate;
	}

}
