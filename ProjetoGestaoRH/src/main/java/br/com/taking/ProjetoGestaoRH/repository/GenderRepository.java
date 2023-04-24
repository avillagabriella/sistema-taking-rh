package br.com.taking.ProjetoGestaoRH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.taking.ProjetoGestaoRH.model.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer>{

}
