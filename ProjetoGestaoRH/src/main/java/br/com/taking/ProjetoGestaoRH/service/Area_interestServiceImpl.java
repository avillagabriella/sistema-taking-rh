package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Area_interest;
import br.com.taking.ProjetoGestaoRH.repository.Area_interestRepository;

@Service
public class Area_interestServiceImpl implements Area_interestService{
	
	@Autowired
	Area_interestRepository area_interestRepository;
	

	@Override
	public List<Area_interest> listar() {
		
		return area_interestRepository.findAll();
	}

	@Override
	public Area_interest incluir(Area_interest areaInteresse) {
		  return area_interestRepository.save(areaInteresse);
	}

	@Override
	public Area_interest ObterPorId(int id) {
		Optional<Area_interest> result = area_interestRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}

	}

	@Override
	public Area_interest Atualizar(int id, Area_interest areaInteresseNew) {
		
		Optional<Area_interest> resultBD = area_interestRepository.findById(id);
		
		if(resultBD.isPresent()) {
		Area_interest areaInteresseBD =	resultBD.get();
		areaInteresseBD.setAreaName(areaInteresseNew.getAreaName());
		 return area_interestRepository.save(areaInteresseBD);
		   }else {
			   return null;
		   }

	}

	
	
	@Override
	public void Deletar(int id) {
	   area_interestRepository.deleteById(id);
		
	}
	

}