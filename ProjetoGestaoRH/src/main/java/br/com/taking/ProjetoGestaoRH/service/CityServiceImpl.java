package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.City;
import br.com.taking.ProjetoGestaoRH.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService{
	
	@Autowired
	CityRepository cityRepository;
	

	@Override
	public List<City> listarTodos() {
	
		return cityRepository.findAll();
	}


	@Override
	public City incluir(City city) {
		return cityRepository.save(city);
	}


	@Override
	public City obterPorId(int id) {
	Optional<City> result =	cityRepository.findById(id);
	if(result.isPresent()) {
		
		return result.get();
	}else {
		return null;
	}

		
	}


	@Override
	public City atualizar(int id, City cityNew) {
		Optional<City> result =	cityRepository.findById(id);
		if(result.isPresent()) {
		City cityBD =	result.get();
		cityBD.setCity(cityNew.getCity());
		cityBD.setCityName(cityNew.getCityName());
		cityBD.setState(cityNew.getState());
		return cityRepository.save(cityBD);
	       }else {
			   return null;
		   }

		
	}


	@Override
	public void deletar(int id) {
		cityRepository.deleteById(id);
		
	}

}
