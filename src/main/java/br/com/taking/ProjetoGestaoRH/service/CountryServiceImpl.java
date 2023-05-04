package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Country;
import br.com.taking.ProjetoGestaoRH.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	CountryRepository countryRepository;
	

	@Override
	public List<Country> listarTodos() {
	
		return countryRepository.findAll();
	}


	@Override
	public Country incluir(Country country) {
		
		return countryRepository.save(country);
	}


	@Override
	public Country obterPorId(int id) {
	
	Optional<Country> result =	countryRepository.findById(id);
	 if(result.isPresent()) {
		 return result.get();
	 }else {
		
	      return null;

	 }
	}


	@Override
	public Country atualizar(int id, Country countryNew) {
		Optional<Country> result =	countryRepository.findById(id);
		if(result.isPresent()) {
		Country countryBD = 	result.get();
		countryBD.setCountryName(countryNew.getCountryName());
		return countryRepository.save(countryBD);
	       }else {
			   return null;
		   }

	}


	@Override
	public void deletar(int id) {
		countryRepository.deleteById(id);
		
	}

}
