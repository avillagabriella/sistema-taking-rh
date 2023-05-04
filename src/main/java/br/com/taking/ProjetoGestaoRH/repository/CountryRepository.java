package br.com.taking.ProjetoGestaoRH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.taking.ProjetoGestaoRH.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
