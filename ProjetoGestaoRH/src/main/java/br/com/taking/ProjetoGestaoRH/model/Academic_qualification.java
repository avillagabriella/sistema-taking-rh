package br.com.taking.ProjetoGestaoRH.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="academic_qualification")
public class Academic_qualification {
	
	@Id
	@Column (name= "academicQualification_id")
	private int academicQualification_id;
		
	@Column(name = "startMonth")
	private Date startMonth;
	
	@Column(name = "startYear")
	private Date startYear;
	
	@Column(name = "endMonth")
	private Date endMonth;
	
	@Column(name = "endYear")
	private Date endYear;
	
	@Column(name = "candidato_id")
	private int candidato_id;
	
	@ManyToOne
	@JoinColumn(name= "formation_id")
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name= "institution_id")
	private Institution institution;
	
	@ManyToOne
	@JoinColumn(name= "course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name= "status_id")
	private Status status;

	public int getAcademicQualification_id() {
		return academicQualification_id;
	}

	public void setAcademicQualification_id(int academicQualification_id) {
		this.academicQualification_id = academicQualification_id;
	}

	public Date getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(Date startMonth) {
		this.startMonth = startMonth;
	}

	public Date getStartYear() {
		return startYear;
	}

	public void setStartYear(Date startYear) {
		this.startYear = startYear;
	}

	public Date getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(Date endMonth) {
		this.endMonth = endMonth;
	}

	public Date getEndYear() {
		return endYear;
	}

	public void setEndYear(Date endYear) {
		this.endYear = endYear;
	}

	public int getCandidato_id() {
		return candidato_id;
	}

	public void setCandidato_id(int candidato_id) {
		this.candidato_id = candidato_id;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	


}