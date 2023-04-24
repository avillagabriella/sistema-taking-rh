package br.com.taking.ProjetoGestaoRH.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="country_Origin")
public class Country_Origin {
	
	
	@Id
	@Column (name= "countryOfOrigin_id")
	private int countryOfOrigin;
	
	@Column (name = "countryOfOrigin ")
	private String countryOfOriginName ;

	public int getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(int countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getCountryOfOriginName() {
		return countryOfOriginName;
	}

	public void setCountryOfOriginName(String countryOfOriginName) {
		this.countryOfOriginName = countryOfOriginName;
	}
	
	


}
