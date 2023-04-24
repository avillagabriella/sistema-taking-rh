package br.com.taking.ProjetoGestaoRH.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="institution")

public class Institution {
	
	@Id
	@Column (name= "institution_id ")
	private int institution;
	
	@Column (name = "institutionName ")
	private String institutionName;

	public int getInstitution() {
		return institution;
	}

	public void setInstitution(int institution) {
		this.institution = institution;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	
	

}
