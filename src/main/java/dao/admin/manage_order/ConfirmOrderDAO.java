package dao.admin.manage_order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectDatabase;

public class ConfirmOrderDAO {
	
	private Connection conn;
	private ConnectDatabase db;
	
	public ConfirmOrderDAO() {
		db=new ConnectDatabase();
		conn=db.getConnection();
	}
	
	public boolean confirmOrder(int orderId) {
		
		boolean isSuccess=false;
		try {
			String query="update orders set state=N'đã xác nhận' where orderId=?";
			PreparedStatement pr=conn.prepareStatement(query);
			pr.setInt(1, orderId);
			
			int i=pr.executeUpdate();
			
			if(i==1) {
				isSuccess=true;
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}

}
