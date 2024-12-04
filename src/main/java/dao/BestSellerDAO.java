package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import entity.Laptop;

public class BestSellerDAO {

	private Connection conn;
	private ConnectDatabase db;
	private List<Laptop> bestSeller;

	public BestSellerDAO() {
		db = new ConnectDatabase();
		conn = db.getConnection();
	}

	public List<Laptop> getBestSeller() {
		bestSeller = new ArrayList<Laptop>();
		try {

			String query = " IF EXISTS (SELECT 1 FROM OrderProduct WHERE ProductType = 'Laptop')\r\n" + "BEGIN\r\n"
					+ "    -- Truy vấn khi bảng OrderProduct có dữ liệu\r\n" + "    SELECT TOP 10 \r\n"
					+ "        l.*\r\n" + "    FROM OrderProduct o\r\n"
					+ "    JOIN Laptop l ON o.ProductType = 'Laptop' AND o.ProductId = l.laptopId\r\n"
					+ "    WHERE o.ProductType = 'Laptop'\r\n" + "    GROUP BY \r\n" + "        l.laptopId, \r\n"
					+ "        l.name, \r\n" + "        l.description, \r\n" + "        l.image, \r\n"
					+ "        l.price, \r\n" + "        l.brand, \r\n" + "        l.category, \r\n"
					+ "        l.cpu, \r\n" + "        l.gpu, \r\n" + "        l.ram, \r\n" + "        l.drive, \r\n"
					+ "        l.size, \r\n" + "        l.resolution, \r\n" + "        l.createdAt\r\n"
					+ "    ORDER BY SUM(o.Quantity) DESC;\r\n" + "END\r\n" + "ELSE\r\n" + "BEGIN\r\n"
					+ "    -- Truy vấn khi bảng OrderProduct trống\r\n" + "    SELECT TOP 10 *\r\n"
					+ "    FROM Laptop\r\n"
					+ "    ORDER BY createdAt DESC; -- Hoặc ORDER BY NEWID() nếu muốn ngẫu nhiên\r\n" + "END;\r\n" + "";
			PreparedStatement pr = conn.prepareStatement(query);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Laptop laptop = new Laptop(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("cpu"),
						rs.getString("gpu"), rs.getString("ram"), rs.getString("drive"), rs.getString("size"),
						rs.getString("resolution"));
				laptop.setLaptopId(rs.getInt("laptopId"));
				bestSeller.add(laptop);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bestSeller;
	}
}
