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


import br.com.taking.ProjetoGestaoRH.model.Gender;
import br.com.taking.ProjetoGestaoRH.service.GenderService;


@RestController
public class GenderController {
	
	@Autowired
	GenderService genderService;
	
	@RequestMapping(value= "/gender", method = RequestMethod.GET)
	public ResponseEntity<List<Gender>> GetALL(){
		
		List<Gender> resultado = genderService.listarTodos();
		return new ResponseEntity<List<Gender>> (resultado, HttpStatus.OK);
		
	}

	//INCLUIR	
	@RequestMapping(value= "/gender", method = RequestMethod.POST) 
	public Gender Post(@RequestBody Gender gender) {
		
		return genderService.incluir(gender);
	}
	
	
	
	//OBTER POR ID
	@RequestMapping(value = "/gender/{id}", method = RequestMethod.GET)
	public ResponseEntity<Gender> GetById(@PathVariable(value ="id") int id){
		 Gender gender = genderService.obterPorId(id);
		 if(gender != null) {
			 return new ResponseEntity<Gender>(gender, HttpStatus.OK );	
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		 }
	}
	
	// ATUALIZAR
	@RequestMapping(value= "/gender/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Gender> Put(@PathVariable (value="id") int id,@RequestBody Gender gender){
	Gender genderAtualizado =genderService.atualizar(id, gender);
	
	    if (genderAtualizado != null) {
             return new ResponseEntity<Gender>(genderAtualizado, HttpStatus.OK);
    	
         }else{
    	    return new ResponseEntity<Gender>( HttpStatus.NOT_FOUND);
	}
	}
	//DELETAR
	  @RequestMapping(value = "/gender/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
		Gender gender = genderService.obterPorId(id);

		if(gender != null) {
			genderService.deletar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}	

	
		
	  
}
