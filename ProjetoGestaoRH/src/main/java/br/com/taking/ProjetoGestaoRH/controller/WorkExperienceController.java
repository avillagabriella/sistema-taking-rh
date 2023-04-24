package br.com.taking.ProjetoGestaoRH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.taking.ProjetoGestaoRH.model.WorkExperience;
import br.com.taking.ProjetoGestaoRH.service.WorkExperienceService;
@RestController
public class WorkExperienceController {
	
	@Autowired
	WorkExperienceService workexperienceService;
	
	//LISTAR
	@RequestMapping(value= "/workExperience", method = RequestMethod.GET)
	public ResponseEntity<List<WorkExperience>> GetALL(){
		
		List<WorkExperience> resultado = workexperienceService.listarTodos();
		return new ResponseEntity<List<WorkExperience>> (resultado, HttpStatus.OK);
		
	}
	
	
	//	INCLUIR
	
	@RequestMapping(value= "/workExperience", method = RequestMethod.POST) 
	public WorkExperience Post(@RequestBody WorkExperience workExperience) {
		return workexperienceService.incluir(workExperience);
	}
	
	
	// OBTER POR ID
	@RequestMapping(value = "/workExperience/{id}", method = RequestMethod.GET)
	public ResponseEntity<WorkExperience> GetById(@PathVariable(value = "id") int id, WorkExperience workExperience){
		WorkExperience workExperienceBD =  workexperienceService.obterPorId(id);
		if(workExperienceBD != null) {
			return new ResponseEntity<WorkExperience> (workExperience, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	          }
	}
	@RequestMapping(value= "/workExperience/{id}", method = RequestMethod.PUT)
	public ResponseEntity<WorkExperience> PUT(@PathVariable(value = "id") int id, @RequestBody WorkExperience workExperience){
	WorkExperience workExperienceAtualizada =	workexperienceService.atualizar(id, workExperience);
	   if(workExperienceAtualizada != null) {
		   return new ResponseEntity<WorkExperience>(workExperienceAtualizada, HttpStatus.OK); 
	   }else {
		   return new ResponseEntity<WorkExperience>(HttpStatus.NOT_FOUND);
	   }
		
	}
	
	//Deletar
	public ResponseEntity<Object> Delete(int id){
		
    WorkExperience workExperience =	workexperienceService.obterPorId(id);
    
    if(workExperience !=null) {
    	workexperienceService.deletar(id);
    	return new ResponseEntity<>(HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}	
}	

	
	

}
