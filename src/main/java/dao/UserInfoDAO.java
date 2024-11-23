package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectDatabase;
import entity.User;

public class UserInfoDAO {

	private Connection conn;
	private ConnectDatabase db;
	
	public UserInfoDAO() {
		db=new ConnectDatabase();
		conn=db.getConnection();
	}

	public User userInfo(int userId) {
		// TODO Auto-generated method stub
		User user = null;

		try {

			String SQLLogin = "SELECT * FROM account WHERE userId=?";
			PreparedStatement pr = conn.prepareStatement(SQLLogin);

			// Gán giá trị cho các tham số
			pr.setInt(1, userId);

			// Sử dụng executeQuery() để thực hiện câu lệnh SELECT
			ResultSet rs = pr.executeQuery();

			// Kiểm tra nếu có kết quả trả về, nghĩa là đăng nhập thành công
			if (rs.next()) {

				user =new User(rs.getString("firstName"), rs.getString("lastName"), "", rs.getString("email"), rs.getString("phoneNumber"));
				user.setUserId(rs.getInt("userId"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getDate("birthday"));
				user.setAvatar(rs.getString("avatar"));
				user.setRole(rs.getString("role"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return user;
	}

}
