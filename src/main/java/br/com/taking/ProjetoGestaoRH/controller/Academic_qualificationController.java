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

import br.com.taking.ProjetoGestaoRH.model.Academic_qualification;
import br.com.taking.ProjetoGestaoRH.service.Academic_qualificationService;

@RestController
public class Academic_qualificationController {
	
	@Autowired
	Academic_qualificationService academic_qualificationService;
	
	@RequestMapping (value= "/academic", method = RequestMethod.GET)
	public ResponseEntity<List<Academic_qualification>> GetALL(){
		
		List<Academic_qualification> resultado = academic_qualificationService.listarTodos();
		return new ResponseEntity<List<Academic_qualification>> (resultado, HttpStatus.OK);
		
	}
	
	//INCLUIR
		@RequestMapping(value= "/academic", method = RequestMethod.POST) 
		public Academic_qualification Post(@RequestBody Academic_qualification academic) {
			
			return academic_qualificationService.incluir(academic);
		}
		
		
		//OBTER POR ID
		@RequestMapping(value="/academic/{id}", method = RequestMethod.GET)
		public ResponseEntity<Academic_qualification> GetByID(Academic_qualification academic,@PathVariable(value = "id") int id){
			Academic_qualification academicID = academic_qualificationService.obterPorId(id);
			if(academicID != null) {
				return new ResponseEntity<Academic_qualification>(academic, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
		 }
		}	
			
			
			//ATUALIZAR
		   @RequestMapping(value="/academic/{id}", method = RequestMethod.PUT)
			public ResponseEntity<Academic_qualification> PUT (@PathVariable (value ="id") int id,
					@RequestBody Academic_qualification academicAtualizar){
				
				Academic_qualification academicAtualizado = academic_qualificationService.atualizar(id, academicAtualizar);
				    if(academicAtualizado != null) {
					  return new ResponseEntity<Academic_qualification>(academicAtualizado, HttpStatus.OK);
				    	
		            }else{
		    	        return new ResponseEntity<Academic_qualification>( HttpStatus.NOT_FOUND);
			  }

			  }
			
			//DELETAR
			  @RequestMapping(value = "/academic/{id}", method = RequestMethod.DELETE)
			  public ResponseEntity<Object> DELETE(@PathVariable int id){
				Academic_qualification academic =  academic_qualificationService.obterPorId(id);
				if(academic != null) {
					academic_qualificationService.deletar(id);
					return new ResponseEntity<>(academic, HttpStatus.OK);
				}else{
		    	    return new ResponseEntity<>( HttpStatus.NOT_FOUND);
				}

			}

}