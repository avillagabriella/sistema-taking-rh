package br.com.taking.ProjetoGestaoRH.controller;

public class FiltroCandidato {
	
private String identificationDocument;
	
	private int gender_id;
	
	private String areaInterest ;
	
	private String activitiesPerformed;
	
	private String courseName;
	
	private String roleName;
	
	private int academicQualification_id;

	public String getIdentificationDocument() {
		return identificationDocument;
	}

	public void setIdentificationDocument(String identificationDocument) {
		this.identificationDocument = identificationDocument;
	}

	
	

	public int getGender_id() {
		return gender_id;
	}

	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}

	public String getAreaInterest() {
		return areaInterest;
	}

	public void setAreaInterest(String areaInterest) {
		this.areaInterest = areaInterest;
	}

	

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getAcademicQualification_id() {
		return academicQualification_id;
	}

	public void setAcademicQualification_id(int academicQualification_id) {
		this.academicQualification_id = academicQualification_id;
	}

	public String getActivitiesPerformed() {
		return activitiesPerformed;
	}

	public void setActivitiesPerformed(String activitiesPerformed) {
		this.activitiesPerformed = activitiesPerformed;
	}

}
