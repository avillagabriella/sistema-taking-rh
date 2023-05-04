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

import br.com.taking.ProjetoGestaoRH.model.State;
import br.com.taking.ProjetoGestaoRH.service.StateService;

@RestController
public class StateController {
	
	@Autowired
	StateService stateService;
	
	
	//LISTAR
	@RequestMapping(value= "/state", method = RequestMethod.GET)
	public ResponseEntity<List<State>> GetALL(){
		
		List<State> resultado = stateService.listarTodos();
		return new ResponseEntity<List<State>> (resultado, HttpStatus.OK);
		
	}
	
	
	//INCLUIR	
		@RequestMapping(value= "/state", method = RequestMethod.POST) 
		public State Post(@RequestBody State state) {
			
			return stateService.incluir(state);
		}

		
		//OBTER POR ID
		@RequestMapping(value = "/state/{id}", method = RequestMethod.GET)
		public ResponseEntity<State> GetById(@PathVariable(value ="id") int id){
			 State state = stateService.obterPorId(id);
			 if(state != null) {
				 return new ResponseEntity<State>(state, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
		
		// ATUALIZAR
		@RequestMapping (value= "/state/{id}", method = RequestMethod.PUT)
		public ResponseEntity<State> Put(@PathVariable (value="id") int id,@RequestBody State state){
		State stateAtualizado = stateService.atualizar(id, state);
		    if (stateAtualizado != null) {
	             return new ResponseEntity<State>(stateAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<State>( HttpStatus.NOT_FOUND);
		      }
		}
		    
		  //DELETAR
			  @RequestMapping(value = "/state/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
			State	state = stateService.obterPorId(id);

				if(state != null) {
					stateService.deletar(id);
					return new ResponseEntity<>(HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
   
		    
		    

			  }
}
