package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.Laptop;
import entity.Peripheral;

public class ListPeripheralDAO {
	
	private Connection conn;
	private ConnectDatabase db;
	private List<Peripheral> listPeripheral;
	
	public ListPeripheralDAO () {
		db=new ConnectDatabase();
		conn = db.getConnection();
	}

	public List<Peripheral> getListPeripheral(int amount) {
		listPeripheral = new ArrayList<Peripheral>();
		try {
			
			String query = "SELECT\r\n"
					+ "* \r\n"
					+ "FROM\r\n"
					+ "    peripheral\r\n"
					+ "ORDER BY\r\n"
					+ "    \r\n"
					+ "    peripheralId\r\n"
					+ "OFFSET ? ROWS \r\n"
					+ "FETCH NEXT 4 ROWS ONLY;\r\n"
					+ "";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, amount);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Peripheral peripheral= new Peripheral(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category")
					  );
				listPeripheral.add(peripheral);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listPeripheral;
	}

}
