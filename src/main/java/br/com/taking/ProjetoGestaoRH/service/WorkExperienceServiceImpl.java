package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.WorkExperience;
import br.com.taking.ProjetoGestaoRH.repository.WorkExperienceRepository;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService{
	
	
	@Autowired
	WorkExperienceRepository workexperienceRepository;
	

	@Override
	public List<WorkExperience> listarTodos() {
	
		return workexperienceRepository.findAll();
	}


	@Override
	public WorkExperience incluir(WorkExperience workExperience) {
	    
		return workexperienceRepository.save(workExperience);
	}


	@Override
	public WorkExperience obterPorId(int id) {
		Optional<WorkExperience> result = workexperienceRepository.findById(id);
		 
		if(result.isPresent()) {
			return result.get();
			}else {
				return null;
			}
	}


	@Override
	public WorkExperience atualizar(int id, WorkExperience workExperienceNew) {
		Optional<WorkExperience> resultBD = workexperienceRepository.findById(id);
		 
		if(resultBD.isPresent()) {
		WorkExperience workExperienceBD =	resultBD.get();
	
		workExperienceBD.setStartYear(workExperienceNew.getStartYear());
		workExperienceBD.setStartMonth(workExperienceNew.getStartMonth());
		workExperienceBD.setRole(workExperienceNew.getRole());
		workExperienceBD.setEndYear(workExperienceNew.getEndYear());
		workExperienceBD.setEndMounth(workExperienceNew.getEndMounth());
		workExperienceBD.setCompanyName(workExperienceNew.getCompanyName());
		workExperienceBD.setActivitiesPerformed(workExperienceNew.getActivitiesPerformed());
	
		workExperienceBD.setActivitiesPerformed(workExperienceNew.getActivitiesPerformed());
			 return workexperienceRepository.save(workExperienceBD);
	       }else {
		   return null;
	   }

	}


	@Override
	public void deletar(int id) {
		workexperienceRepository.deleteById(id);
		
	}


}