package br.com.taking.ProjetoGestaoRH.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="languages_skill")
public class Languages_skill {
	
	@Id
	@Column (name= "languagesskill_id ")
	private int languagesskill;
	
	//@Id
	@Column (name= "candidato_id ")
	private int candidato_id;
		
	@ManyToOne
	@JoinColumn(name= "language_id")
	private Languages language;
	
	@ManyToOne
	@JoinColumn(name= "level_id")
	private Level level;

	public int getLanguagesskill() {
		return languagesskill;
	}

	public void setLanguagesskill(int languagesskill) {
		this.languagesskill = languagesskill;
	}

	public int getCandidato_id() {
		return candidato_id;
	}

	public void setCandidato_id(int candidato_id) {
		this.candidato_id = candidato_id;
	}

	public Languages getLanguage() {
		return language;
	}

	public void setLanguage(Languages language) {
		this.language = language;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}


	


}
