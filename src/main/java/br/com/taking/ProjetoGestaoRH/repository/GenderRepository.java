package br.com.taking.ProjetoGestaoRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import br.com.taking.ProjetoGestaoRH.model.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer>{

	

	@Query("select c from Gender c where c.gender = :gender" )
	public List<Gender> findByGender(String gender);
	
}
