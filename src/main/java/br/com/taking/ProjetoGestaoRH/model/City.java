package br.com.taking.ProjetoGestaoRH.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="city")

public class City {
	
	
	@Id
	@Column (name= "city_id")
	private int city;
	
	@Column (name = "city")
	private String cityName;

		
	@ManyToOne
	@JoinColumn(name= "state_id")
	private State state;


	public int getCity() {
		return city;
	}


	public void setCity(int city) {
		this.city = city;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	



}
