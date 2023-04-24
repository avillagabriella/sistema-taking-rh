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

import br.com.taking.ProjetoGestaoRH.model.Area_interest;
import br.com.taking.ProjetoGestaoRH.service.Area_interestService;




@RestController
public class Area_interestController {
	
	@Autowired
	Area_interestService areaInteresseService;
    
	//LISTAR
	@RequestMapping(value= "/areaInteresse", method = RequestMethod.GET)
	public ResponseEntity<List<Area_interest>> Listar(){
	 List<Area_interest> resultado = areaInteresseService.listar();
		return new ResponseEntity<List<Area_interest>>(resultado, HttpStatus.OK);
   }
	
	
	//INCLUIR
	
	@RequestMapping(value= "/areaInteresse", method = RequestMethod.POST) 
	public Area_interest Post(@RequestBody Area_interest areaInteresse) {
		
		return areaInteresseService.incluir(areaInteresse);
	}

			
	
	
	
	//OBTER POR ID
		
	@RequestMapping(value = "/areaInteresse/{id}", method = RequestMethod.GET)
	public ResponseEntity<Area_interest> GetById(@PathVariable int id){
		 Area_interest areaInteresse = areaInteresseService.ObterPorId(id);
		 if(areaInteresse != null) {
			 return new ResponseEntity<Area_interest>(areaInteresse, HttpStatus.OK);
			  }else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }	 

		 }
	
	
	//ATUALIZAR
	
	
	@RequestMapping(value= "/areaInteresse/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Area_interest> Put(@PathVariable (value="id") int id,@RequestBody Area_interest areaInteresse){
	Area_interest areaInteresseAtualizada = areaInteresseService.Atualizar(id, areaInteresse);
	
	    if (areaInteresseAtualizada != null) {
             return new ResponseEntity<Area_interest>(areaInteresseAtualizada, HttpStatus.OK);
    	
         }else{
    	    return new ResponseEntity<Area_interest>( HttpStatus.NOT_FOUND);
	}
	}


	
	//DELETAR
	
	 @RequestMapping(value = "/areaInteresse/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
	Area_interest areaInteresseBD = areaInteresseService.ObterPorId(id);
		if(areaInteresseBD != null) {
		areaInteresseService.Deletar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}	

	


}