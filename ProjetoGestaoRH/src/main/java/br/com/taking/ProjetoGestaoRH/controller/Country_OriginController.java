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

import br.com.taking.ProjetoGestaoRH.model.Country_Origin;
import br.com.taking.ProjetoGestaoRH.service.Country_OriginService;

@RestController
public class Country_OriginController {
	
	@Autowired
	Country_OriginService country_originService;
	
	@RequestMapping(value= "/country_origin", method = RequestMethod.GET)
	public ResponseEntity<List<Country_Origin>> GetALL(){
		
		List<Country_Origin> resultado = country_originService.listarTodos();
		return new ResponseEntity<List<Country_Origin>> (resultado, HttpStatus.OK);
		
	}
	
	
	//INCLUIR	
		@RequestMapping(value= "/country_origin", method = RequestMethod.POST) 
		public Country_Origin Post(@RequestBody Country_Origin countryOrigin) {
			
			return country_originService.incluir(countryOrigin);
		}
		

		//OBTER POR ID
		@RequestMapping(value = "/country_origin/{id}", method = RequestMethod.GET)
		public ResponseEntity<Country_Origin> GetById(@PathVariable(value ="id") int id){
			 Country_Origin country_Origin = country_originService.obterPorId(id);
			 if(country_Origin != null) {
				 return new ResponseEntity<Country_Origin>(country_Origin, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
		
		
		// ATUALIZAR
		@RequestMapping(value= "/country_origin/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Country_Origin> Put(@PathVariable (value="id") int id,@RequestBody Country_Origin countryOrigin){
		Country_Origin countryAtualizado = country_originService.atualizar(id, countryOrigin);
		
		    if (countryAtualizado != null) {
	             return new ResponseEntity<Country_Origin>(countryAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Country_Origin>( HttpStatus.NOT_FOUND);
		}
		}

		//DELETAR
		  @RequestMapping(value = "/country_origin/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
			Country_Origin countryOrigin = country_originService.obterPorId(id);
			if(countryOrigin != null) {
				country_originService.deletar(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		  }

}
