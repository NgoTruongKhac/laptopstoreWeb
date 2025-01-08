package dao.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import model.Laptop;
import model.Peripheral;

public class SearchProductDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Laptop> listLaptop;
	private List<Peripheral> listPeripheral;

	public SearchProductDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
		this.listLaptop = new ArrayList<Laptop>();
		this.listPeripheral = new ArrayList<Peripheral>();
	}

	public List<Laptop> getListLaptop(String searchText) {

		try {

			String query = "SELECT p.productId, p.name, p.description, p.image, p.price, p.brand, "
					+ "   l.category, l.cpu, l.gpu, l.ram, l.drive, l.size, l.resolution " + "FROM laptop l"
					+ " JOIN product p ON l.productId = p.productId " + "where p.name like ?;";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setString(1, "%"+searchText+"%");
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Laptop laptop = new Laptop(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("cpu"),
						rs.getString("gpu"), rs.getString("ram"), rs.getString("drive"), rs.getString("size"),
						rs.getString("resolution"));
				laptop.setLaptopId(rs.getInt("productId"));
				listLaptop.add(laptop);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listLaptop;

	}

	public List<Peripheral> getListPeripheral(String searchText) {
		try {

			String query = "SELECT p.productId, p.name, p.description, p.image, p.price, p.brand,"
					+ "       pe.category, pe.connect,pe.ledRGB \r\n" + "FROM peripheral pe "
					+ "JOIN product p ON pe.productId = p.productId " + "where p.name like ?";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setString(1, "%"+searchText+"%");

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Peripheral peripheral = new Peripheral(rs.getString("name"), rs.getString("description"),
						rs.getString("image"), rs.getInt("price"), rs.getString("brand"), rs.getString("category"),
						rs.getString("connect"), rs.getBoolean("ledRGB"));
				peripheral.setPeripheralId(rs.getInt("productId"));
				listPeripheral.add(peripheral);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listPeripheral;

	}

}
