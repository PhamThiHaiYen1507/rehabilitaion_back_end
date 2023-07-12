package com.haiyen.rehap.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class PatientsInfo {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "gender")
	private String gender;

	@OneToOne(mappedBy = "patient")
	private MedicalReCord medicalRecord;

	@JsonIgnore
	public MedicalReCord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalReCord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	@OneToMany(mappedBy = "patient")
	private List<MedicalHistory> medicalHistoryList;

	@JsonIgnore
	public List<MedicalHistory> getMedicalHistoryList() {
		return medicalHistoryList;
	}

	public void setMedicalHistoryList(List<MedicalHistory> medicalHistoryList) {
		this.medicalHistoryList = medicalHistoryList;
	}

	@OneToMany(mappedBy = "patient")
	private List<Schedule> scheduleList;

	@JsonIgnore
	public List<Schedule> getSchedule() {
		return scheduleList;
	}

	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	@OneToMany(mappedBy = "patient")
	private List<Call> callList;

	@JsonIgnore
	public List<Call> getCall() {
		return callList;
	}

	public void setCallList(List<Call> callList) {
		this.callList = callList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}