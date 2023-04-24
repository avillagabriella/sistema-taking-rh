package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Gender;
import br.com.taking.ProjetoGestaoRH.repository.GenderRepository;

@Service
public class GenderServiceImpl implements GenderService{
	
	@Autowired
	GenderRepository genderRepository;
	

	@Override
	public List<Gender> listarTodos() {
	
		return genderRepository.findAll();
	}


	@Override
	public Gender incluir(Gender gender) {
	
		return genderRepository.save(gender);
	}


	@Override
	public Gender obterPorId(int id) {
	
		Optional<Gender> result = genderRepository.findById(id);
			if(result.isPresent()) {
				return result.get();
				}else {
					return null;
							
	}
}


	@Override
	public Gender atualizar(int id, Gender genderNew) {
		Optional<Gender> result = genderRepository.findById(id);
		if(result.isPresent()) {
		 Gender resultBD =	result.get();
		 resultBD.setGender(genderNew.getGender());
		 return genderRepository.save(resultBD);
		  }else {
			   return null;
		   }

	}


	@Override
	public void deletar(int id) {
		genderRepository.deleteById(id);
		
	}

}