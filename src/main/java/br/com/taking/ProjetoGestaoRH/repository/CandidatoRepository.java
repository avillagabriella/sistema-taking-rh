package br.com.taking.ProjetoGestaoRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.taking.ProjetoGestaoRH.model.Candidato;


public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{
	
	
	// Nome da entidade e atributo
	@Query("select c from Candidato c where c.identificationDocument= :identificationDocument" )
	List<Candidato> findAll(String identificationDocument);
	
	
	// FILTRO DE CANDIDATO POR INTERVALO DE IDADE
	@Query("select c from Candidato c where DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(c.birthdate, '%Y') >= :age1 " +
            "and DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(c.birthdate, '%Y') <= :age2 " +
	        "and DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(c.birthdate, '%Y') <= 40 " +
	        "and DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(c.birthdate, '%Y') >= 18")
    
	List<Candidato> filterAges(int age1, int age2);
	
	
	
	@Query("SELECT c FROM Candidato c "
			+ "LEFT JOIN c.areaInterest ai "
			+ "LEFT JOIN c.workExperience_id we "
			+ "LEFT JOIN we.role rl "
			+ "LEFT JOIN c.academicQualification_id aq "
			+ "LEFT JOIN aq.status aqSt "
			+ "LEFT JOIN aq.course co "
			+ "WHERE "
			+ "(c.identificationDocument = :identificationDocument OR :identificationDocument is null) " //documento
			+ "AND (c.gender.gender = :genderId OR :genderId = 0) " //genero
			+ "AND (we.activitiesPerformed like concat('%', :activitiesPerformed, '%') OR :activitiesPerformed is null) " //activities performed
			+ "AND (ai.areaName like concat('%', :areaInterest, '%') OR :areaInterest is null) " // areas de interesse
			+ "AND (co.courseName like concat('%', :courseName, '%') OR :courseName is null) " // curso (da qualificacao academica)
			+ "AND (rl.roleName like concat('%', :roleName, '%') OR :roleName is null) " // papel (da experiencia profissional)
			+ "AND (aqSt.status = :academicQualification_id OR :academicQualification_id = 0)") // status da formacao academica
	List<Candidato> filter(
			
		     @Param("identificationDocument")String identificationDocument,
		     @Param("genderId")int genderId,
		     @Param("areaInterest")String areaInterest,
		     @Param("activitiesPerformed")String activitiesPerformed,
		     @Param("courseName")String courseName,
		     @Param("roleName")String roleName,
		     @Param("academicQualification_id")int academicQualification_id);
	
	
}
	
	
	