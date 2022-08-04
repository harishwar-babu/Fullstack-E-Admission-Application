package com.example.Eadmission.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String userRole;
	private String username;
	private String mobileNumber;
	private String email;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	public UserModel(Long id, String userRole, String username, String mobileNumber, String email, String password) {
		this.id = id;
		this.userRole = userRole;
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}
	public UserModel() {
	}
}