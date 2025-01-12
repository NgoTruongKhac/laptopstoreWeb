package dao.admin.manage_product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDatabase;
import model.Peripheral;

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
			
			
			String query = "SELECT p.productId, p.name, p.description, p.image, p.price, p.brand, "
		             + "       pe.category, pe.connect, pe.ledRGB, "
		             + "       COUNT(r.reviewId) AS quantityReview, "
		             + "       COALESCE(AVG(r.rate), 0) AS avgRate "
		             + "FROM peripheral pe "
		             + "JOIN product p ON pe.productId = p.productId "
		             + "LEFT JOIN reviews r ON r.productId = p.productId "
		             + "GROUP BY p.productId, p.name, p.description, p.image, p.price, p.brand, "
		             + "         pe.category, pe.connect, pe.ledRGB "
		             + "ORDER BY p.productId "
		             + "OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY;";

			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, amount);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Peripheral peripheral= new Peripheral( rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"),rs.getString("connect"),rs.getBoolean("ledRGB")
					  );
				peripheral.setPeripheralId(rs.getInt("productId"));
				peripheral.setRate(rs.getDouble("avgRate"));
				peripheral.setQuantityReview(rs.getInt("quantityReview"));
				listPeripheral.add(peripheral);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listPeripheral;
	}
	public List<Peripheral> getListPeripheralManage(int page,int pageSize) {
		listPeripheral = new ArrayList<Peripheral>();
		
		
	    
	    int offset = (page - 1) * pageSize;
		
		try {
			
			String query = "SELECT p.productId, p.name, p.description, p.image, p.price, p.brand, \r\n"
					+ "       pe.category, pe.connect,pe.ledRGB \r\n"
					+  "FROM peripheral pe\r\n" + "JOIN product p ON pe.productId = p.productId\r\n"
					+ "ORDER BY p.productId\r\n" + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;\r\n";
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, offset);
			pr.setInt(2, pageSize);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Peripheral peripheral= new Peripheral(rs.getString("name"), rs.getString("description"), rs.getString("image"),
						rs.getInt("price"), rs.getString("brand"), rs.getString("category"), rs.getString("connect"),rs.getBoolean("ledRGB")
					 );
				peripheral.setPeripheralId(rs.getInt("productId"));
				listPeripheral.add(peripheral);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listPeripheral;
	}
	public int getTotalProductCount() {
	    int totalProducts = 0;
	    try {
	        String query = "SELECT COUNT(*) FROM peripheral";
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
