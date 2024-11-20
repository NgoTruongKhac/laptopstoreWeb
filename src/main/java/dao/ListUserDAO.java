package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.User;

public class ListUserDAO {
	
	private Connection conn;
	private ConnectDatabase db;
	private List<User> listUser;
	
	public ListUserDAO () {
		db=new ConnectDatabase();
		conn = db.getConnection();
	}
	
	public List<User> GetListUser(int page,int pageSize){
		listUser=new ArrayList<User>();
		 int offset = (page - 1) * pageSize;
		try {
			
			String query="SELECT * FROM account ORDER BY userId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			PreparedStatement pr=conn.prepareStatement(query);
			pr.setInt(1, offset);
			pr.setInt(2, pageSize);
			ResultSet rs=pr.executeQuery();
			
			while(rs.next()) {
				User user=new User(rs.getString("firstName"), rs.getString("lastName"), "", rs.getString("email"), rs.getString("phoneNumber"), "");
				user.setUserId(rs.getInt("userId"));
				user.setBirthday(rs.getDate("birthday"));
				
				listUser.add(user);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listUser;
	}
	public int getTotalUser() {
	    int totalProducts = 0;
	    try {
	        String query = "SELECT COUNT(*) FROM account";
	        PreparedStatement pr = conn.prepareStatement(query);
	        ResultSet rs = pr.executeQuery();
	        if (rs.next()) {
	            totalProducts = rs.getInt(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return totalProducts;
	}

}
