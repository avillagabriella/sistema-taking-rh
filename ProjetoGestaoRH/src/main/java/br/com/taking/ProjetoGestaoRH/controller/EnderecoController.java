package br.com.taking.ProjetoGestaoRH.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.taking.ProjetoGestaoRH.service.EnderecoService;
import br.com.taking.ProjetoGestaoRH.service.dto.EnderecoDto;

@RestController
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;	
	
	
	@RequestMapping(value = "/endereco{cep}", method = RequestMethod.GET)
	public ResponseEntity<EnderecoDto> GET(@PathVariable (value ="cep") String cepInformado){
	EnderecoDto resultado = enderecoService.obterPorCep(cepInformado);
	 return  new ResponseEntity<EnderecoDto>(resultado, HttpStatus.OK);
	}

}
