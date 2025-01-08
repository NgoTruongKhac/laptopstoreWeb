package dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import model.Address;

public class ListAddressDAO {
	
	private Connection conn;
	private ConnectDatabase db;
	private List<Address> listAddress;
	
	public ListAddressDAO() {
		db=new ConnectDatabase();
		conn=db.getConnection();
	}
	
	public List<Address> getListAddress(int userId){
		
		listAddress=new ArrayList<Address>();
		
		try {
			 String sql= "SELECT * FROM address WHERE userId = ?";
			 PreparedStatement pr=conn.prepareStatement(sql);
			 
			 pr.setInt(1, userId);
			 
			 ResultSet rs=pr.executeQuery();
			 
			 while(rs.next()) {
				 Address address = new Address(
						    rs.getString("nameAddress"),
						    rs.getString("province"),
						    rs.getString("district"),
						    rs.getString("ward"),
						    rs.getString("street"),
						    rs.getBoolean("isDefault")
						);
				 address.setAddressId(rs.getInt("addressId")); //set them addressId
				 listAddress.add(address);
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listAddress;
		
	}
	
	

}
