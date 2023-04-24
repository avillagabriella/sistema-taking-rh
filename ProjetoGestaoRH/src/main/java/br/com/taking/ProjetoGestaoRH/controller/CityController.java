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

import br.com.taking.ProjetoGestaoRH.model.City;
import br.com.taking.ProjetoGestaoRH.service.CityService;

@RestController
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@RequestMapping(value= "/city", method = RequestMethod.GET)
	public ResponseEntity<List<City>> GetALL(){
		
		List<City> resultado = cityService.listarTodos();
		return new ResponseEntity<List<City>> (resultado, HttpStatus.OK);
		
	}
	
	//INCLUIR	
	@RequestMapping(value= "/city", method = RequestMethod.POST) 
	public City Post(@RequestBody City city) {
		
		return cityService.incluir(city);
	}
	
	
	//OBTER POR ID
	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
	public ResponseEntity<City> GetById(@PathVariable(value ="id") int id){
		 City city  = cityService.obterPorId(id);
		 if(city != null) {
			 return new ResponseEntity<City>(city, HttpStatus.OK );	
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		 }
	}

	// ATUALIZAR
	@RequestMapping(value= "/city/{id}", method = RequestMethod.PUT)
	public ResponseEntity<City> Put(@PathVariable (value="id") int id,@RequestBody City city){
	City  cityAtualizado = cityService.atualizar(id, city);
	
	    if (cityAtualizado != null) {
             return new ResponseEntity<City>(cityAtualizado, HttpStatus.OK);
    	
         }else{
    	    return new ResponseEntity<City>( HttpStatus.NOT_FOUND);
	}
}

	  //DELETAR
		  @RequestMapping(value = "/city/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
			City city = cityService.obterPorId(id);

			if(city != null) {
				cityService.deletar(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}	
		}

	

}
