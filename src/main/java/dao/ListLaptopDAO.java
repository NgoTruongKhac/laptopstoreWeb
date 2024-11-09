package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.Laptop;

public class ListLaptopDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Laptop> listLaptop;
	
	public ListLaptopDAO () {
		db=new ConnectDatabase();
		conn = db.getConnection();
	}

	public List<Laptop> getListLaptop() {
		listLaptop = new ArrayList<Laptop>();
		try {
			
			String query = "SELECT * FROM laptop";
			PreparedStatement pr = conn.prepareStatement(query);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Laptop laptop = new Laptop(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("cpu"), 
					    rs.getString("gpu"), 
					    rs.getString("ram"), 
					    rs.getString("drive"), 
					    rs.getString("size"), 
					    rs.getString("resolution"));
				listLaptop.add(laptop);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listLaptop;
	}

}
