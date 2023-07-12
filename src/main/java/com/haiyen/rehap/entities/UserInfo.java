package com.haiyen.rehap.entities;
import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserInfo {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "is_doctor")
	private boolean isDoctor;

	@Column(name = "create_at")
	private Date createAt;

	@Column(name = "name")
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsDoctor() {
		return isDoctor;
	}

	public void setIsDoctor(boolean isDoctor) {
		this.isDoctor = isDoctor;
	}
	

}
