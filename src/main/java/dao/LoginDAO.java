package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bcrypt.BCrypt;
import database.ConnectDatabase;
import entity.User;

public class LoginDAO {

	private Connection conn;
	private ConnectDatabase db;
	private boolean isCorrectPass;

	public LoginDAO() {
		db=new ConnectDatabase();
		conn=db.getConnection();
		this.isCorrectPass=true;
	}
	
	public User isSuccess(String emailOrPhone, String pass) {
		// TODO Auto-generated method stub
		User user=null;
		
		

		try {
			
			String SQLLogin = "SELECT * FROM account WHERE email = ? or phoneNumber= ?";
			PreparedStatement pr = conn.prepareStatement(SQLLogin);

			// Gán giá trị cho các tham số
			pr.setString(1, emailOrPhone);
			pr.setString(2, emailOrPhone);
			

			// Sử dụng executeQuery() để thực hiện câu lệnh SELECT
			ResultSet rs = pr.executeQuery();

			// Kiểm tra nếu có kết quả trả về, nghĩa là đăng nhập thành công
			if (rs.next()) {
				String hashedPass=rs.getString("pass");
				
				if(BCrypt.checkpw(pass, hashedPass)) {
					user=new User(rs.getString("firstName"), rs.getString("lastName"), "", rs.getString("email"), rs.getString("phoneNumber"));
					user.setUserId(rs.getInt("userId"));
					user.setSex(rs.getString("sex"));
					user.setBirthday(rs.getDate("birthday"));
					user.setAvatar(rs.getString("avatar"));
					user.setRole(rs.getString("role"));
				}
				else {
					isCorrectPass=false;
					
				}
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}
		return user;
		
	}
	public boolean getIsCorrectPass() {
		return isCorrectPass;
	}
	

}
