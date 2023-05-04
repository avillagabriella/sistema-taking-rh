package br.com.taking.ProjetoGestaoRH.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name= "work_experience")
public class WorkExperience {
	
	@Id
	@Column(name = "workExperience_id")
	private int workExperience_id;
	
	@Column(name = "candidato_id")
	private int candidato_id;

	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "activitiesPerformed")
	private String activitiesPerformed;
	
	@Column(name = "startMonth")
	private Date startMonth;
	
	@Column(name = "startYear")
	private Date startYear;
	
	@Column(name = "endMonth")
	private Date endMounth;
	
	@Column(name = "endYear")
	private Date endYear;
	
	
	//@ManyToOne (optional = true)
	//@JoinColumn(name= "candidato_id")
	//private Candidato candidato;

	
	@ManyToOne (optional = true)
	@JoinColumn(name= "role_id")
	private Role role;


	public int getWorkExperience_id() {
		return workExperience_id;
	}


	public void setWorkExperience_id(int workExperience_id) {
		this.workExperience_id = workExperience_id;
	}


	public int getCandidato_id() {
		return candidato_id;
	}


	public void setCandidato_id(int candidato_id) {
		this.candidato_id = candidato_id;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getActivitiesPerformed() {
		return activitiesPerformed;
	}


	public void setActivitiesPerformed(String activitiesPerformed) {
		this.activitiesPerformed = activitiesPerformed;
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


	public Date getEndMounth() {
		return endMounth;
	}


	public void setEndMounth(Date endMounth) {
		this.endMounth = endMounth;
	}


	public Date getEndYear() {
		return endYear;
	}


	public void setEndYear(Date endYear) {
		this.endYear = endYear;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}







	

	
}