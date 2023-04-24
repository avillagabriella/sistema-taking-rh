package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Languages_skill;
import br.com.taking.ProjetoGestaoRH.repository.Languages_skillRepository;


@Service
public class Languages_skillServiceImpl implements Languages_skillService{
	
	@Autowired
	Languages_skillRepository languages_skillRepository;
	

	@Override
	public List<Languages_skill> listarTodos() {
	
		return languages_skillRepository.findAll();
	}


	@Override
	public Languages_skill incluir(Languages_skill languageSkill) {
		return languages_skillRepository.save(languageSkill);
	}


	@Override
	public Languages_skill obterPorId(int id) {
	 Optional<Languages_skill> result =  languages_skillRepository.findById(id);
	 if(result.isPresent()) {
		 return result.get();
	 }else {
		 return null;
	 }
		
		
		
	}


	@Override
	public Languages_skill atualizar(int id, Languages_skill languageSkillNew) {
		 Optional<Languages_skill> result =  languages_skillRepository.findById(id);
		 if(result.isPresent()) {
			Languages_skill languageSkillBD = result.get();
			languageSkillBD.setLanguage(languageSkillNew.getLanguage());
			languageSkillBD.setLanguagesskill(languageSkillBD.getLanguagesskill());
			languageSkillBD.setLevel(languageSkillBD.getLevel());
			return languages_skillRepository.save(languageSkillBD);
		 }else {
			 return null;
		 }
	}


	@Override
	public void deletar(int id) {
		languages_skillRepository.deleteById(id);
		
	}

}
