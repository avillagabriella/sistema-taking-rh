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

import br.com.taking.ProjetoGestaoRH.model.Disability_type;
import br.com.taking.ProjetoGestaoRH.service.Disability_typeService;

@RestController
public class Disability_typeController {
	
	@Autowired
	Disability_typeService disability_typeService;
	
	@RequestMapping(value= "/disability_type", method = RequestMethod.GET)
	public ResponseEntity<List<Disability_type>> GetALL(){
		
		List<Disability_type> resultado = disability_typeService.listarTodos();
		return new ResponseEntity<List<Disability_type>> (resultado, HttpStatus.OK);
		
	}
	
	
	//INCLUIR	
	@RequestMapping(value= "/disability_type", method = RequestMethod.POST) 
	public Disability_type Post(@RequestBody Disability_type disability) {
		
		return disability_typeService. incluir(disability);
	}
	
   
	
	
	//OBTER POR ID
		@RequestMapping(value = "/disability_type/{id}", method = RequestMethod.GET)
		public ResponseEntity<Disability_type> GetById(@PathVariable(value ="id") int id){
			 Disability_type disability =  disability_typeService.obterPorId(id);
			 if(disability != null) {
				 return new ResponseEntity<Disability_type>(disability, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
		
		// ATUALIZAR
		@RequestMapping(value= "/disability_type/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Disability_type> Put(@PathVariable (value="id") int id,@RequestBody Disability_type disability){
	   Disability_type disabilityAtualizado = disability_typeService.atualizar(id, disability);
		
		    if ( disabilityAtualizado != null) {
	             return new ResponseEntity<Disability_type>(disabilityAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Disability_type>( HttpStatus.NOT_FOUND);
		}
		}
		    
			//DELETAR
			  @RequestMapping(value = "/disability_type/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
				Disability_type disability =  disability_typeService.obterPorId(id);

				if(disability != null) {
					disability_typeService.deletar(id);
					return new ResponseEntity<>(HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}	
			}




}
