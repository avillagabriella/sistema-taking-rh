package br.com.taking.ProjetoGestaoRH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
