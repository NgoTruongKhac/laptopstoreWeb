package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectDatabase;

public class DeleteUserDAO {
	
	private Connection conn;
	private ConnectDatabase db;
	
	public DeleteUserDAO() {
		db=new ConnectDatabase();
		conn=db.getConnection();
	}
	
	public boolean isDeleteUser(int userId) {
		boolean isDeleteUser=false;
		
		
		try {
			
			String query="delete from account where userId=?;";
			PreparedStatement pr=conn.prepareStatement(query);
			
			pr.setInt(1, userId);
			
			int i=pr.executeUpdate();
			
			if(i==1) {
				isDeleteUser=true;
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return isDeleteUser;
	}

}
