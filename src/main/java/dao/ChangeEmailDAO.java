package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectDatabase;

public class ChangeEmailDAO {
	
	private Connection conn;
	private ConnectDatabase db;
	
	public ChangeEmailDAO() {
		db=new ConnectDatabase();
		conn=db.getConnection();
	}
	
	public boolean isSuccess(String oldEmail) {
		// TODO Auto-generated method stub
		boolean isRegister = true;

		try {
		

			String insertSQL = "  select * from account where email=?;";
			PreparedStatement pr = conn.prepareStatement(insertSQL);
			
			pr.setString(1, oldEmail);
		
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

	public boolean isChangeEmail(String newEmail, int userId) {
		boolean isChangeEmail=false;
		try {
			String sql="update account set email=? where userId=?;";
			PreparedStatement pr=conn.prepareStatement(sql);
			
			pr.setString(1, newEmail);
			pr.setInt(2, userId);
			
			int i=pr.executeUpdate();
			
			if(i==1) {
				isChangeEmail=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isChangeEmail;
		
		
		
	}

}
