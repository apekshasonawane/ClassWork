package com.ust.manytomany.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Student1")
public class Student {
	@Id
	@Column
	private int studentId;
	@Column
	private String studentName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="StudentCourses",joinColumns=@JoinColumn(name="studentId"),
	inverseJoinColumns = @JoinColumn(name="courseId"))
	private List<Course> courseId;

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

	public List<Course> getCourseId() {
		return courseId;
	}

	public void setCourseId(List<Course> courseId) {
		this.courseId = courseId;
	}
	
	

	
}	
