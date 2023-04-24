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

import br.com.taking.ProjetoGestaoRH.model.Role;
import br.com.taking.ProjetoGestaoRH.service.RoleService;
@RestController
public class RoleController {

	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value= "/role", method = RequestMethod.GET)
	public ResponseEntity<List<Role>> GetALL(){
		
		List<Role> resultado = roleService.listarTodos();
		return new ResponseEntity<List<Role>> (resultado, HttpStatus.OK);
		
	}
	
	//INCLUIR	
		@RequestMapping(value= "/role", method = RequestMethod.POST) 
		public Role Post(@RequestBody Role role) {
			
			return roleService.incluir(role);
		}
		
		

		//OBTER POR ID
		@RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
		public ResponseEntity<Role> GetById(@PathVariable(value ="id") int id){
			 Role role = roleService.obterPorId(id);
			 if(role != null) {
				 return new ResponseEntity<Role>(role, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
		
		
		// ATUALIZAR
		@RequestMapping(value= "/role/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Role> Put(@PathVariable (value="id") int id,@RequestBody Role role){
		Role roleAtualizado = roleService.atualizar(id, role);
		
		    if (roleAtualizado != null) {
	             return new ResponseEntity<Role>(roleAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Role>( HttpStatus.NOT_FOUND);
		}
		}
		
		//DELETAR
		  @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
			Role role = roleService.obterPorId(id);

			if(role != null) {
				 roleService.deletar(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		  }
}