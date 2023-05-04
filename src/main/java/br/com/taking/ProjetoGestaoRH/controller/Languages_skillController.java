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

import br.com.taking.ProjetoGestaoRH.model.Languages_skill;
import br.com.taking.ProjetoGestaoRH.service.Languages_skillService;

@RestController
public class Languages_skillController {
	
	@Autowired
	Languages_skillService languages_skillService;
	
	@RequestMapping(value= "/languages_skill", method = RequestMethod.GET)
	public ResponseEntity<List<Languages_skill>> GetALL(){
		
		List<Languages_skill> resultado = languages_skillService.listarTodos();
		return new ResponseEntity<List<Languages_skill>> (resultado, HttpStatus.OK);
		
	}
	//INCLUIR	
		@RequestMapping(value= "/languages_skill", method = RequestMethod.POST) 
		public Languages_skill Post(@RequestBody Languages_skill languages_skill) {
			
			return languages_skillService.incluir(languages_skill);
		}

		//OBTER POR ID
		@RequestMapping(value = "/languages_skill/{id}", method = RequestMethod.GET)
		public ResponseEntity<Languages_skill> GetById(@PathVariable(value ="id") int id){
			 Languages_skill languageSkill = languages_skillService.obterPorId(id);
			 if(languageSkill != null) {
				 return new ResponseEntity<Languages_skill>(languageSkill, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
		
		// ATUALIZAR
		@RequestMapping(value= "/languages_skill/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Languages_skill> Put(@PathVariable (value="id") int id,@RequestBody Languages_skill languageSkill){
		Languages_skill languageSkillAtualizado = languages_skillService.atualizar(id, languageSkill); 
		
		    if (languageSkillAtualizado != null) {
	             return new ResponseEntity<Languages_skill>(languageSkillAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Languages_skill>( HttpStatus.NOT_FOUND);
		}
		    
		}	    
		    
		  //DELETAR
			  @RequestMapping(value = "/languages_skill/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
				Languages_skill languageSkill = languages_skillService.obterPorId(id);

				if(languageSkill != null) {
					languages_skillService.deletar(id);
					return new ResponseEntity<>(HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}	
			}
			  
}

		    
		    
		    
		    
		


	



