package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Formation;
import br.com.taking.ProjetoGestaoRH.repository.FormationRepository;

@Service
public class FormationServiceImpl implements FormationService{
	

	@Autowired
	FormationRepository formationRepository;
	

	@Override
	public List<Formation> listarTodos() {
	
		return formationRepository.findAll();
	}


	@Override
	public Formation incluir(Formation formation) {
	return formationRepository.save(formation);
	}


	@Override
	public Formation obterPorId(int id) {
		
	  Optional<Formation> result = formationRepository.findById(id);
	  if(result.isPresent()) {
		  return result.get();
		}else {
			return null;
		
	  }
	}


	@Override
	public Formation atualizar(int id, Formation formationNew) {
		Optional<Formation> result = formationRepository.findById(id);
		  if(result.isPresent()) {
			  Formation resultBD =  result.get();
			  resultBD.setFormationName(formationNew.getFormationName());
			  return formationRepository.save(resultBD);
	       }else {
			   return null;
		   }

	}


	@Override
	public void deletar(int id) {
	  formationRepository.deleteById(id);
		
	}

}

