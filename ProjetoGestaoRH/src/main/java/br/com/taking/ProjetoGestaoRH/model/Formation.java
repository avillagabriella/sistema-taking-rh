package br.com.taking.ProjetoGestaoRH.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="formation")
public class Formation {
	
	@Id
	@Column (name= "formation_id ")
	private int formation;
	
	@Column (name = "formationName  ")
	private String formationName  ;

	public int getFormation() {
		return formation;
	}

	public void setFormation(int formation) {
		this.formation = formation;
	}

	public String getFormationName() {
		return formationName;
	}

	public void setFormationName(String formationName) {
		this.formationName = formationName;
	}

	

	
	
}
