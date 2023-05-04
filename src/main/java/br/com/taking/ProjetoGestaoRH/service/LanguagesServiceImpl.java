package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Languages;
import br.com.taking.ProjetoGestaoRH.repository.LanguagesRepository;

@Service
public class LanguagesServiceImpl implements LanguagesService{
	
	@Autowired
	LanguagesRepository languagesRepository;
	

	@Override
	public List<Languages> listarTodos() {
	
		return languagesRepository.findAll();
	}


	@Override
	public Languages incluir(Languages languages) {
		return languagesRepository.save(languages);
	}


	@Override
	public Languages obterPorId(int id) {
	Optional<Languages>	result = languagesRepository.findById(id);
	if(result.isPresent()) {
	  return result.get();
	}else {
		return null;
	}
	}


	@Override
	public Languages atualizar(int id, Languages languagesNew) {
		Optional<Languages>	result = languagesRepository.findById(id);
		if(result.isPresent()) {
			Languages languagesBD = result.get();
			languagesBD.setLanguageName(languagesNew.getLanguageName());
		 return	languagesRepository.save(languagesBD);
		}else {
			return null;
		}
	}


	@Override
	public void deletar(int id) {
		languagesRepository.deleteById(id);
		
	}

}
