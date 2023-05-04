package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Disability_type;
import br.com.taking.ProjetoGestaoRH.repository.Disability_typeRepository;

@Service
public class Disability_typeServiceImpl implements Disability_typeService{
	
	@Autowired
	Disability_typeRepository disability_typeRepository;
	

	@Override
	public List<Disability_type> listarTodos() {
	
		return disability_typeRepository.findAll();
	}


	@Override
	public Disability_type incluir(Disability_type disabilityType) {
		
		return disability_typeRepository.save(disabilityType);
	}


	@Override
	public Disability_type obterPorId(int id) {
		Optional<Disability_type> result = disability_typeRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
	}


	@Override
	public Disability_type atualizar(int id, Disability_type disabilityTypeNew) {
		Optional<Disability_type> result = disability_typeRepository.findById(id);
		
		if(result.isPresent()) {
			Disability_type disabilityTypeBD = result.get();
			disabilityTypeBD.setDisabilityType(disabilityTypeNew.getDisabilityType());
			return disability_typeRepository.save(disabilityTypeBD);
		}else {
			return null;
		}
	}


	@Override
	public void deletar(int id) {
		disability_typeRepository.deleteById(id);
		
	}

}
