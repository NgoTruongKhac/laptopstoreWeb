package entity;

public class UserInfoOrder {
	
	private int userId;
	private String firstName;
	private String LastName;
	private String pass;
	private String email;
	private String phoneNumber;
	
	private String province;
	private String district;
	private String ward;
	private String street;
	private String note;
	public UserInfoOrder(int userId, String firstName, String lastName, String pass, String email, String phoneNumber,
			String province, String district, String ward, String street, String note) {
		this.userId = userId;
		this.firstName = firstName;
		LastName = lastName;
		this.pass = pass;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.province = province;
		this.district = district;
		this.ward = ward;
		this.street = street;
		this.note = note;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	

}
