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

import br.com.taking.ProjetoGestaoRH.model.Level;
import br.com.taking.ProjetoGestaoRH.service.LevelService;

@RestController
public class LevelController {
	
	@Autowired
	LevelService levelService;
	
	@RequestMapping(value= "/level", method = RequestMethod.GET)
	public ResponseEntity<List<Level>> GetALL(){
		
		List<Level> resultado = levelService.listarTodos();
		return new ResponseEntity<List<Level>> (resultado, HttpStatus.OK);
		
	}

	
	//INCLUIR	
	@RequestMapping(value= "/level", method = RequestMethod.POST) 
	public Level Post(@RequestBody Level level) {
			
			return levelService.incluir(level);
		}
		

	//OBTER POR ID
	@RequestMapping(value = "/level/{id}", method = RequestMethod.GET)
	public ResponseEntity<Level> GetById(@PathVariable(value ="id") int id){
			 Level level = levelService.obterPorId(id);
			 if(level != null) {
				 return new ResponseEntity<Level>(level, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
	
	// ATUALIZAR
		@RequestMapping(value= "/level/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Level> Put(@PathVariable (value="id") int id,@RequestBody Level level){
		Level levelAtualizado = levelService.atualizar(id, level);
		
		    if (levelAtualizado != null) {
	             return new ResponseEntity<Level>(levelAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Level>( HttpStatus.NOT_FOUND);
		}
		}
		//DELETAR
		  @RequestMapping(value = "/level/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
			Level level = levelService.obterPorId(id);

			if(level != null) {
				levelService.deletar(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}	
		}	

		



}
