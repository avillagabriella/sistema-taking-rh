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

import br.com.taking.ProjetoGestaoRH.model.Course;
import br.com.taking.ProjetoGestaoRH.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value= "/course", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> GetALL(){
		
		List<Course> resultado = courseService.listarTodos();
		return new ResponseEntity<List<Course>> (resultado, HttpStatus.OK);
		
	}
	
	
	//INCLUIR	
		@RequestMapping(value= "/course", method = RequestMethod.POST) 
		public Course Post(@RequestBody Course course) {
			
			return courseService.incluir(course);
		}
		
		//OBTER POR ID
		@RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
		public ResponseEntity<Course> GetById(@PathVariable(value ="id") int id){
			 Course course = courseService.obterPorId(id);
			 if(course != null) {
				 return new ResponseEntity<Course>(course, HttpStatus.OK );	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
		
		
		// ATUALIZAR
		@RequestMapping(value= "/course/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Course> Put(@PathVariable (value="id") int id,@RequestBody Course course){
		Course courseAtualizado =   courseService.atualizar(id, course);
		
		    if (courseAtualizado != null) {
	             return new ResponseEntity<Course>(courseAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Course>( HttpStatus.NOT_FOUND);
		}
		}
		
		
		
		//DELETAR
		  @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
			Course course = courseService.obterPorId(id);

			if(course != null) {
				 courseService.deletar(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}	
		}


		


}
