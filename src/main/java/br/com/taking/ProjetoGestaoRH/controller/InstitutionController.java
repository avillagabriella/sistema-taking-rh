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

import br.com.taking.ProjetoGestaoRH.model.Institution;
import br.com.taking.ProjetoGestaoRH.service.InstitutionService;

@RestController
public class InstitutionController {
	
	@Autowired
	InstitutionService institutionService;
	
	@RequestMapping(value= "/institution", method = RequestMethod.GET)
	public ResponseEntity<List<Institution>> GetALL(){
		
		List<Institution> resultado = institutionService.listarTodos();
		return new ResponseEntity<List<Institution>> (resultado, HttpStatus.OK);
		
	}
	
	//INCLUIR	
		@RequestMapping(value= "/institution", method = RequestMethod.POST) 
		public Institution Post(@RequestBody Institution institution) {
			
			return institutionService.incluir(institution);
		}

		//OBTER POR ID
		@RequestMapping(value = "/institution/{id}", method = RequestMethod.GET)
		public ResponseEntity<Institution> GetById(@PathVariable(value ="id") int id){
			 Institution institution = institutionService.obterPorId(id);
			 if(institution != null) {
				 return new ResponseEntity<Institution>(institution, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
  
				
		// ATUALIZAR
		@RequestMapping(value= "/institution/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Institution> Put(@PathVariable (value="id") int id,@RequestBody Institution institution){
		   Institution institutionAtualizado = institutionService.atualizar(id, institution);
				
		        if (institutionAtualizado  != null) {
			             return new ResponseEntity<Institution>(institutionAtualizado , HttpStatus.OK);
			    	
			         }else{
			    	    return new ResponseEntity<Institution>( HttpStatus.NOT_FOUND);
				}
		 }
				
				
				
		//DELETAR
		@RequestMapping(value = "/institution/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
		  Institution institution = institutionService.obterPorId(id);
			if(institution != null) {
			    institutionService.deletar(id); 
			     return new ResponseEntity<>(HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}	
				}


	
	
	

}
