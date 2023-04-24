package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.taking.ProjetoGestaoRH.model.Country_Origin;
import br.com.taking.ProjetoGestaoRH.repository.Country_OriginRepository;

@Service
public class Country_OriginServiceImpl implements Country_OriginService{
	
	@Autowired
	Country_OriginRepository country_originRepository;
	

	@Override
	public List<Country_Origin> listarTodos() {
	
		return country_originRepository.findAll();
	}


	@Override
	public Country_Origin incluir(Country_Origin country) {
		
		return country_originRepository.save(country);
	}


	@Override
	public Country_Origin obterPorId(int id) {
	   Optional<Country_Origin> result = country_originRepository.findById(id);
	   if(result.isPresent()) {
		   return result.get();
	   }else {
			return null;
		}

		   }
	   
		
	


	@Override
	public Country_Origin atualizar(int id, Country_Origin countryNew) {
		 Optional<Country_Origin> result = country_originRepository.findById(id);
		 if(result.isPresent()) {
			Country_Origin countryOriginBD = result.get();
			countryOriginBD.setCountryOfOrigin(countryNew.getCountryOfOrigin());
			countryOriginBD.setCountryOfOriginName(countryOriginBD.getCountryOfOriginName());
			return country_originRepository.save(countryOriginBD);
	       }else {
			   return null;
		   }

		 
	}


	@Override
	public void deletar(int id) {
		country_originRepository.deleteById(id);
		
	}

}