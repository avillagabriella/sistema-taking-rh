package br.com.taking.ProjetoGestaoRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.taking.ProjetoGestaoRH.model.Candidato;


public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{
	
	
	// Nome da entidade e atributo
	@Query("select c from Candidato c where c.identificationDocument= :identificationDocument" )
	List<Candidato> findAll(String identificationDocument);
	
	@Query("select c from Candidato c where c.firstName= :firstName" )
	 List<Candidato> findByFirstName(String firstName);
	
	
}
	
	
	