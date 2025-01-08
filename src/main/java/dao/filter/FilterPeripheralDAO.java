package dao.filter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import database.ConnectDatabase;
import model.Peripheral;

public class FilterPeripheralDAO {
	private Connection conn;
	private ConnectDatabase db;
	private List<Peripheral> listPeripheral;

	public FilterPeripheralDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
		this.listPeripheral = new ArrayList<Peripheral>();
	}

	public List<Peripheral> getListPeripheral(Map<String, List<String>> filters, int priceFrom, int priceTo) {

		try {

			StringBuilder query = new StringBuilder(
					"select * from product p join peripheral pe on p.productId=pe.productId where 1=1 and price between ? and ?");

			filters.forEach((column, values) -> {
				if (!values.isEmpty()) {

					query.append(" AND ").append(column);

					query.append(" IN (").append(String.join(",", Collections.nCopies(values.size(), "?"))).append(")");
				}
			});

			PreparedStatement pr = conn.prepareStatement(query.toString());

			pr.setInt(1, priceFrom);
			pr.setInt(2, priceTo);

			int index = 3;
			for (Map.Entry<String, List<String>> entry : filters.entrySet()) {
				String column = entry.getKey();
				List<String> values = entry.getValue();

				for (String value : values) {

					if (column.equalsIgnoreCase("ledRGB")) {
						// Xử lý cột ledRGB với giá trị Boolean
						pr.setBoolean(index++, "1".equals(value));
					} else {
						pr.setString(index++, value);
					}
				}
			}

			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Peripheral peripheral = new Peripheral(rs.getString("name"), rs.getString("description"),
						rs.getString("image"), rs.getInt("price"), rs.getString("brand"), rs.getString("category"),
						rs.getString("connect"), rs.getBoolean("ledRGB"));
				peripheral.setPeripheralId(rs.getInt("productId"));
				listPeripheral.add(peripheral);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listPeripheral;
	}
}
