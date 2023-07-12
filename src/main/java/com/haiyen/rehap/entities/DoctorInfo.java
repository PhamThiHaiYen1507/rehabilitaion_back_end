package com.haiyen.rehap.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class DoctorInfo {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "experence")
	private int experence;

	@Column(name = "degree")
	private String degree;

	@Column(name = "describe")
	private String describe;

	@Column(name = "fields")
	private String fields;

	@Column(name = "avatar")
	private String avatar;

	@OneToMany(mappedBy = "doctor")
	private List<MedicalHistory> medicalHistoryList;

	@JsonIgnore
	public List<MedicalHistory> getMedicalHistoryList() {
		return medicalHistoryList;
	}

	public void setMedicalHistoryList(List<MedicalHistory> medicalHistoryList) {
		this.medicalHistoryList = medicalHistoryList;
	}

	@OneToMany(mappedBy = "doctor")
	private List<Schedule> scheduleList;

	@JsonIgnore
	public List<Schedule> getSchedule() {
		return scheduleList;
	}

	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	@OneToMany(mappedBy = "doctor")
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

	public int getExperence() {
		return experence;
	}

	public void setExperence(int experence) {
		this.experence = experence;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

}
