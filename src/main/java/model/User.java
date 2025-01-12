package model;

import java.sql.Date;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private String pass;
	private String email;
	private String phoneNumber;
	private String sex;
	private Date birthday;
	private String avatar;
	private String role;

	public User(String firstName, String lastName, String pass, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pass = pass;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public User(String firstName, String lastName, String sex, Date birthday, String avatar,String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.birthday = birthday;
		this.avatar = avatar;
		this.phoneNumber=phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", LastName=" + lastName + ", pass=" + pass
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", sex=" + sex + ", birthday=" + birthday
				+ ", avatar=" + avatar + ", role=" + role + "]";
	}

}
