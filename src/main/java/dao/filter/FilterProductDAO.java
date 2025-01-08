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
import model.Laptop;

public class FilterProductDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Laptop> listLaptop;

	public FilterProductDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
		this.listLaptop = new ArrayList<Laptop>();
	}

	public List<Laptop> getListLaptop(Map<String, List<String>> filters, int priceFrom, int priceTo) {
		try {
			StringBuilder query = new StringBuilder(
					"select * from product p join laptop l on p.productId=l.productId where 1=1 and price between ? and ?");

			filters.forEach((column, values) -> {
				if (!values.isEmpty()) {

//					query.append(" AND ").append(column).append(" IN (")
//							.append(String.join(",", Collections.nCopies(values.size(), "?"))).append(")");
					query.append(" AND ").append(column);

					if ("cpu".equalsIgnoreCase(column)) {
						// Xử lý logic LIKE cho các cột trong tập hợp
						values.forEach(value -> query.append(" LIKE ? OR "));
						query.setLength(query.length() - 4); // Xóa " OR " cuối cùng
					} else {
						// Xử lý mặc định với IN
						query.append(" IN (").append(String.join(",", Collections.nCopies(values.size(), "?")))
								.append(")");
					}
				}
			});

			PreparedStatement pr = conn.prepareStatement(query.toString());
			pr.setInt(1, priceFrom);
			pr.setInt(2, priceTo);

//			for (List<String> values : filters.values()) {
//				for (String value : values) {
//					pr.setString(index++, value);
//				}
//			}
			int index = 3;
			for (Map.Entry<String, List<String>> entry : filters.entrySet()) {
				String column = entry.getKey();
				List<String> values = entry.getValue();

				for (String value : values) {
					// Nếu là cột "cpu", thêm "%" vào cuối value
					if (column.equalsIgnoreCase("cpu")) {
						pr.setString(index++, value + "%");
					} else {
						pr.setString(index++, value);
					}
				}
			}

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

}
