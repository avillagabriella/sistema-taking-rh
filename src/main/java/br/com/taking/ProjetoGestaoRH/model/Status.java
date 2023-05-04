package br.com.taking.ProjetoGestaoRH.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table (name="status")


public class Status {
	
	@Id
	@Column (name= "status_id  ")
	private int status;
	
	@Column (name = "statusName ")
	private String statusName ;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
		

	


}
