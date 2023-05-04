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

import br.com.taking.ProjetoGestaoRH.model.Status;
import br.com.taking.ProjetoGestaoRH.service.StatusService;

@RestController
public class StatusController {
	
	@Autowired
	StatusService statusService;
	
	@RequestMapping(value= "/status", method = RequestMethod.GET)
	public ResponseEntity<List<Status>> GetALL(){
		
		List<Status> resultado = statusService.listarTodos();
		return new ResponseEntity<List<Status>> (resultado, HttpStatus.OK);
		
	}
	
	
	//INCLUIR	
		@RequestMapping(value= "/status", method = RequestMethod.POST) 
		public Status Post(@RequestBody Status status) {
			
			return statusService.incluir(status);
					
		}
		
		
	//OBTER POR ID
		@RequestMapping(value = "/status/{id}", method = RequestMethod.GET)
		public ResponseEntity<Status> GetById(@PathVariable(value ="id") int id){
			Status status = statusService.obterPorId(id);
			 if(status != null) {
				 return new ResponseEntity<Status>(status, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}

		
		// ATUALIZAR
		@RequestMapping(value= "/status/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Status> Put(@PathVariable (value="id") int id,@RequestBody Status status){
		  Status statusAtualizado = statusService.atualizar(id, status);
		
		    if (statusAtualizado != null) {
	             return new ResponseEntity<Status>(statusAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Status>( HttpStatus.NOT_FOUND);
		}
		    }

		  //DELETAR
			  @RequestMapping(value = "/status/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
				Status status = statusService.obterPorId(id);

				if(status != null) {
					statusService.deletar(id);
					return new ResponseEntity<>(HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}

		
		
	

}}