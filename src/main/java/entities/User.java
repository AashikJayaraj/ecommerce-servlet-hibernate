package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@Column(length =10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String email;
	private String password;
	private String userPhone;
	@Column(length = 1500)
	private String address;
	private String userType;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(int userId, String name, String email, String password, String userPhone, String userPic, String address, String userType) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userPhone = userPhone;
		this.address = address;
		this.userType = userType;
	}
	public User(String name, String email, String password, String userPhone, String address, String userType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userPhone = userPhone;
		this.address = address;
		this.userType = userType;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	

}
