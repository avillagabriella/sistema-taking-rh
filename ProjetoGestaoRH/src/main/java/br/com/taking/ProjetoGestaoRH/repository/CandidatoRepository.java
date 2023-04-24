package br.com.taking.ProjetoGestaoRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.taking.ProjetoGestaoRH.model.Candidato;


public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{
	
	
	
	@Query("select c from Candidato c where c.identificationDocument= :identificationDocument" )
	public List<Candidato> findAll(String identificationDocument);
	
	   //Candidato findByIdentificationDocument(String identification);
	   
       // nome da entidade e atributo  // c.id(do meu bd seja igual id dentro parametro abaixo
	//@Query("select c from Candidato c where c.id = :id or c.nome = :firstName or  c.numero = :identificationDocument")
	//List<FiltroCandidato> filter (int id, String firstName, String identificationDocument);
	   
	   
    // nome da entidade e atributo
     //@Query("select c from Candidato c where c.id = :id or c.nome = :nome or  c.numero = :numero")
    //  List<Candidato> filter (int id, String nome, String numero);
	


}