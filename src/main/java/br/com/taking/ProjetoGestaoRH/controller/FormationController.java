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

import br.com.taking.ProjetoGestaoRH.model.Formation;
import br.com.taking.ProjetoGestaoRH.service.FormationService;

@RestController
public class FormationController {
	
	@Autowired
	FormationService formationService;
	
	@RequestMapping(value= "/formation", method = RequestMethod.GET)
	public ResponseEntity<List<Formation>> GetALL(){
		
		List<Formation> resultado = formationService.listarTodos();
		return new ResponseEntity<List<Formation>> (resultado, HttpStatus.OK);
		
	}
	
	
	
	//INCLUIR	
		@RequestMapping(value= "/formation", method = RequestMethod.POST) 
		public Formation Post(@RequestBody Formation formation) {
			
			return formationService.incluir(formation);	
			
		}
		


		
		
		//OBTER POR ID
		@RequestMapping(value = "/formation/{id}", method = RequestMethod.GET)
		public ResponseEntity<Formation> GetById(@PathVariable(value ="id") int id){
			Formation formation = formationService.obterPorId(id);
			 if(formation != null) {
				 return new ResponseEntity<Formation>(formation, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
		
		
		// ATUALIZAR
		@RequestMapping(value= "/formation/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Formation> Put(@PathVariable (value="id") int id,@RequestBody Formation formation){
		Formation formationAtualizado = formationService.atualizar(id, formation);
		
		    if (formationAtualizado != null) {
	             return new ResponseEntity<Formation>(formationAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Formation>( HttpStatus.NOT_FOUND);
		   }

 	}
		
		
		//DELETAR
		  @RequestMapping(value = "/formation/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
		Formation formation = formationService.obterPorId(id);

			if(formation != null) {
				  formationService.deletar(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}	
		}	

		
		
}
