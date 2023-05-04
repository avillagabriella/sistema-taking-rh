package br.com.taking.ProjetoGestaoRH.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="area_interest")
public class Area_interest {
	
	@Id
	@Column (name= "areaInterest_id ")
	private int areaInterest_id ;
	
	@Column (name = "areaName  ")
	private String areaName  ;

	public int getAreaInterest_id() {
		return areaInterest_id;
	}

	public void setAreaInterest_id(int areaInterest_id) {
		this.areaInterest_id = areaInterest_id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}



}