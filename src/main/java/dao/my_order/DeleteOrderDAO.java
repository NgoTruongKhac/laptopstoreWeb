package dao.my_order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectDatabase;

public class DeleteOrderDAO {
	
	private Connection conn;
	private ConnectDatabase db;

	public DeleteOrderDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean isDeleteOrder(int oderId) {
		boolean isSucces=false;
		
		try {
			
			String query="delete from orders where orderId=?";
			PreparedStatement pr=conn.prepareStatement(query);
			pr.setInt(1, oderId);
			
			int i=pr.executeUpdate();
			
			if(i==1) {
				isSucces=true;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return isSucces ;
	}

}
