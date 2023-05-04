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

import br.com.taking.ProjetoGestaoRH.model.Languages;

import br.com.taking.ProjetoGestaoRH.service.LanguagesService;

@RestController
public class LanguagesController {
	
	@Autowired
    LanguagesService languagesService;
	
	
	//LISTAR
		@RequestMapping(value= "/languages", method = RequestMethod.GET)
		public ResponseEntity<List<Languages>> GetALL(){
			
			List<Languages> resultado = languagesService.listarTodos();
			return new ResponseEntity<List<Languages>> (resultado, HttpStatus.OK);
			
		}
		
		
		//INCLUIR	
		@RequestMapping(value= "/languages", method = RequestMethod.POST) 
		public Languages Post(@RequestBody Languages languages) {
			
			return languagesService.incluir(languages);
		}
		
		
		
		//OBTER POR ID
		@RequestMapping(value = "/languages/{id}", method = RequestMethod.GET)
		public ResponseEntity<Languages> GetById(@PathVariable(value ="id") int id){
			Languages languages = languagesService.obterPorId(id);
			 if(languages != null) {
				 return new ResponseEntity<Languages>(languages, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
		
		// ATUALIZAR
		@RequestMapping(value= "/languages/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Languages> Put(@PathVariable (value="id") int id,@RequestBody Languages languages){
		 Languages languagesAtualizado = languagesService.atualizar(id, null);
		
		    if (languagesAtualizado != null) {
	             return new ResponseEntity<Languages>(languagesAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Languages>( HttpStatus.NOT_FOUND);
		}
		}
		//DELETAR
		  @RequestMapping(value = "/api/cliente/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
			Languages languages = languagesService.obterPorId(id);

			if(languages!= null) {
				languagesService.deletar(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}	
		}	



	



}
