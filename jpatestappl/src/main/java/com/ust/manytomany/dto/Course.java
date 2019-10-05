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
@Table(name="Course")
public class Course {
	@Id
	@Column
	private int courseId;
	@Column
	private String courseName;
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "courseId")
//	@JoinTable(name="StudentCourses",joinColumns=@JoinColumn(name="courseId"),
//	inverseJoinColumns = @JoinColumn(name="studentId"))
	private List<Student> studentId;
	
	public int getCourseId() {
		return courseId;
	}
	public List<Student> getStudentId() {
		return studentId;
	}
	public void setStudentId(List<Student> studentId) {
		this.studentId = studentId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
