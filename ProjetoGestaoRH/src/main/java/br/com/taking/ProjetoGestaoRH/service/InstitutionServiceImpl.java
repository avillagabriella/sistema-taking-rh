package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Institution;
import br.com.taking.ProjetoGestaoRH.repository.InstitutionRepository;

@Service
public class InstitutionServiceImpl implements InstitutionService{
	
	@Autowired
	InstitutionRepository institutionRepository;
	

	@Override
	public List<Institution> listarTodos() {
	
		return institutionRepository.findAll();
	}


	@Override
	public Institution incluir(Institution institution) {
		return institutionRepository.save(institution);
	}


	@Override
	public Institution obterPorId(int id) {
		 
		Optional<Institution>  result = institutionRepository.findById(id);
		     if(result.isPresent()) {
				return result.get();
				  }else {
					return null;
				}

	}


	@Override
	public Institution atualizar(int id, Institution institutionNew) {
		Optional<Institution>  result = institutionRepository.findById(id);
		
		if(result.isPresent()) {
			Institution resultBD =   result.get();
			resultBD.setInstitutionName(institutionNew.getInstitutionName());
			return institutionRepository.save(resultBD);
	       }else {
			   return null;
		   }

		}
	


	@Override
	public void deletar(int id) {
		institutionRepository.deleteById(id);
		
	}



}
