package br.com.taking.ProjetoGestaoRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.taking.ProjetoGestaoRH.model.Candidato;


public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{


    @Query("select c from Candidato c where c.identificationDocument= :identificationDocument")
    public List<Candidato> findAll(String identificationDocument);

    @Query("select c from Candidato c where DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(c.birthdate, '%Y') >= :age1 " +
            "and DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(c.birthdate, '%Y') <= :age2 " +
            "and DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(c.birthdate, '%Y') <= 35 " +
            "and DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(c.birthdate, '%Y') >= 18")
    List<Candidato> filterAges(int age1, int age2);


    @Query("select c from Candidato c where DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(c.birthdate, '%Y') = :age")
    List<Candidato> filterDate(int age);

    @Query("select c, ls, l, lv from Candidato c, Languages_skill ls, Languages l, Level lv WHERE c.candidato_id = ls.candidato_id AND ls.language.language = l.language AND lv.level = ls.language.language AND l.languageName = :language" )
    List<Candidato> filterLanguages(String language);

    //Candidato findByIdentificationDocument(String identification);
    // nome da entidade e atributo  // c.id(do meu bd seja igual id dentro parametro abaixo
    //@Query("select c from Candidato c where c.id = :id or c.nome = :firstName or  c.numero = :identificationDocument")
    //List<FiltroCandidato> filter (int id, String firstName, String identificationDocument);

    // nome da entidade e atributo
    //@Query("select c from Candidato c where c.id = :id or c.nome = :nome or  c.numero = :numero")
    //  List<Candidato> filter (int id, String nome, String numero);
}