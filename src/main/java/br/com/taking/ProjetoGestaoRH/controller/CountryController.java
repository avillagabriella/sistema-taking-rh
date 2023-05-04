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

import br.com.taking.ProjetoGestaoRH.model.Country;
import br.com.taking.ProjetoGestaoRH.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value= "/country", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> GetALL(){
		
		List<Country> resultado = countryService.listarTodos();
		return new ResponseEntity<List<Country>> (resultado, HttpStatus.OK);
		
	}

	
	//INCLUIR	
		@RequestMapping(value= "/country", method = RequestMethod.POST) 
		public Country Post(@RequestBody Country country) {
			
			return countryService.incluir(country);
		}

		//OBTER POR ID
		@RequestMapping(value = "/country/{id}", method = RequestMethod.GET)
		public ResponseEntity<Country> GetById(@PathVariable(value ="id") int id){
			Country country = countryService.obterPorId(id);
			 if(country != null) {
				 return new ResponseEntity<Country>(country, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
		
		// ATUALIZAR
		@RequestMapping(value= "/country/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Country> Put(@PathVariable (value="id") int id,@RequestBody Country country){
		Country countryAtualizado = countryService.atualizar(id,  country);		
		    if (countryAtualizado != null) {
	             return new ResponseEntity<Country>(countryAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Country>( HttpStatus.NOT_FOUND);
		}
     }
		    
		  //DELETAR
			  @RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
			Country country = countryService.obterPorId(id);

				if(country != null) {
					countryService.deletar(id);
					return new ResponseEntity<>(HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}	
			}	

		    
		    
		    
}



