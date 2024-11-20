package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.ConnectDatabase;
import entity.Laptop;

public class AddLaptopDAO {

	private Connection conn;
	private ConnectDatabase db;

	public AddLaptopDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public boolean isAddLaptop(Laptop laptop) {
		boolean isSuccess = false;
		try {
			String qery = "insert into laptop (name,description,image,price,brand,category,cpu,gpu,ram,drive,size,resolution) values(?,?,?,?,?,?,?,?,?,?,?,?); ";
			PreparedStatement pr = conn.prepareStatement(qery);

			pr.setString(1, laptop.getName());
			pr.setString(2, laptop.getDescription());
			pr.setString(3, laptop.getImage());
			pr.setInt(4, laptop.getPrice());
			pr.setString(5, laptop.getBrand());
			pr.setString(6, laptop.getCategory());
			pr.setString(7, laptop.getCpu());
			pr.setString(8, laptop.getGpu());
			pr.setString(9, laptop.getRam());
			pr.setString(10, laptop.getDrive());
			pr.setString(11, laptop.getSize());
			pr.setString(12, laptop.getResolution());
			
			int i=pr.executeUpdate();
			
			if(i==1) {
				isSuccess=true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSuccess;
	}

}
