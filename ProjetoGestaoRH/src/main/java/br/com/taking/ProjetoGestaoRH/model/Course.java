package br.com.taking.ProjetoGestaoRH.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="course")

public class Course {
	
	@Id
	@Column (name= "course_id ")
	private int course_id;
	
	@Column (name = "courseName")
	private String courseName;
		

	public int getCourse_id () {
		return course_id;
	}

	public void setCourse_id (int course_id ) {
		this.course_id  = course_id ;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	

}
