package br.com.taking.ProjetoGestaoRH.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="country")

public class Country {
	
	
	@Id
	@Column (name= "country_id")
	private int country;
	
	@Column (name = "country")
	private String countryName;

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
	

}
