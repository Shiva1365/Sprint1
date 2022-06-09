package com.edusystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student_table")
public class StudentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_contact")
	private long studentContact;

	@Column(name = "student_email", unique = true, nullable = false)
	private String studentEmail;

	@Column(name = "Student_address")
	private String studentAddress;

	@Column(name = "gender")
	private String gender;

	@Column(name = "student_password")
	private String studentPassword;

	@OneToMany(mappedBy = "studentDetails", cascade = CascadeType.ALL)
	private List<Payment> payment = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "studentDetails", cascade = CascadeType.ALL)
	private List<StudentSelectedCourse> studentSelectedCourse = new ArrayList<>();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getStudentContact() {
		return studentContact;
	}

	public void setStudentContact(long studentContact) {
		this.studentContact = studentContact;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public List<StudentSelectedCourse> getStudentSelectedCourse() {
		return studentSelectedCourse;
	}

	public void setStudentSelectedCourse(List<StudentSelectedCourse> studentSelectedCourse) {
		this.studentSelectedCourse = studentSelectedCourse;
	}

}
