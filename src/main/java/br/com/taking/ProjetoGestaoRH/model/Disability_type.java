package br.com.taking.ProjetoGestaoRH.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="disability_type")

public class Disability_type {
	
	
	@Id
	@Column (name= "disability_id ")
	private int disability;
	
	@Column (name = "disabilityType")
	private String disabilityType;

	public int getDisability() {
		return disability;
	}

	public void setDisability(int disability) {
		this.disability = disability;
	}

	public String getDisabilityType() {
		return disabilityType;
	}

	public void setDisabilityType(String disabilityType) {
		this.disabilityType = disabilityType;
	}
	
	


}
