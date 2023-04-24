package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;

import br.com.taking.ProjetoGestaoRH.model.Languages_skill;



public interface Languages_skillService {
	
	List<Languages_skill> listarTodos();
   
	Languages_skill  incluir(Languages_skill languageSkill);
	
	Languages_skill obterPorId(int id);
	
	Languages_skill atualizar (int id, Languages_skill languageSkillNew);
	
	void deletar (int id);



}
