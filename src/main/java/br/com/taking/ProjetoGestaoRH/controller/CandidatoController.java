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

import br.com.taking.ProjetoGestaoRH.model.Candidato;
import br.com.taking.ProjetoGestaoRH.repository.CandidatoRepository;
import br.com.taking.ProjetoGestaoRH.service.CandidatoService;

@RestController
public class CandidatoController {
	
	@Autowired
	CandidatoService candidatoService;
	
	@Autowired
    private CandidatoRepository candidatoRepository;
	
	@RequestMapping(value= "/candidato", method = RequestMethod.GET)
	public ResponseEntity<List<Candidato>> GetALL(){
		
		List<Candidato> resultado = candidatoService.listarTodos();
		return new ResponseEntity<List<Candidato>> (resultado, HttpStatus.OK);
		
	}

	
	
	//INCLUIR	
		@RequestMapping(value= "/candidato", method = RequestMethod.POST) 
		public Candidato Post(@RequestBody Candidato candidato) {
			
			return candidatoService.incluir(candidato);
		}

		
		
		
		
		//OBTER POR ID
		@RequestMapping(value = "/candidato/{id}", method = RequestMethod.GET)
		public ResponseEntity<Candidato> GetById(@PathVariable(value ="id") int id){
			 Candidato candidato = candidatoService.obterPorId(id);
			 if(candidato != null) {
				 return new ResponseEntity<Candidato>(candidato, HttpStatus.OK );
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			 }
		}
		
		// ATUALIZAR
		@RequestMapping(value= "/candidato/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Candidato> Put(@PathVariable (value="id") int id,@RequestBody Candidato candidato){
		Candidato candidatoAtualizado = candidatoService.atualizar(id, candidato);
		
		    if (candidatoAtualizado != null) {
	             return new ResponseEntity<Candidato>(candidatoAtualizado, HttpStatus.OK);
	    	
	         }else{
	    	    return new ResponseEntity<Candidato>( HttpStatus.NOT_FOUND);
		}
		}
		//DELETAR
		  @RequestMapping(value = "/candidato/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id){
				Candidato cliente = candidatoService.obterPorId(id);
				if(cliente != null) {
					candidatoService.deletar(id);
					return new ResponseEntity<>(HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}	
			}
		  
		 
		  //FILTRO Documento
		  
		  @RequestMapping(value = "/candidato/filter{identificationDocument}", method = RequestMethod.GET)
		  public ResponseEntity<List<Candidato>> FindByIdentification(@PathVariable (value= "identificationDocument") String identification){
			  
			List<Candidato> candidato =  candidatoService.findByIdentificationDocument(identification);
			if(candidato != null) {
				return new ResponseEntity<>(candidato, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			}
			
		  }
		  
		//FILTRAR CANDIDATO POR INTERVALO DE IDADE
		  @RequestMapping(value = "/candidato/ages/{age1}/{age2}", method = RequestMethod.GET)
		  public List<Candidato> FilterAge(@PathVariable(value = "age1") int age1, @PathVariable(value = "age2") int age2) {
			  return candidatoRepository.filterAges(age1, age2);
		    }
		  
		  
		  
		  
		  @RequestMapping(value = "/candidato/filtrocandidato/", method = RequestMethod.POST)
			public List<Candidato> Filter(@RequestBody FiltroCandidato filtro){
				
				String identificationDocumentFiltro = filtro.getIdentificationDocument();
				
				int gender_idFiltro = filtro.getGender_id();
				
				String areaInterestFiltro = filtro.getAreaInterest ();
				
				String activitiesPerformedFiltro = filtro.getActivitiesPerformed();
				
				String courseNameFiltro = filtro.getCourseName();
				
				String roleNameFiltro = filtro.getRoleName();
				
				int academicQualification_idFiltro = filtro.getAcademicQualification_id();
			
			

				return candidatoService.filtrar(identificationDocumentFiltro, gender_idFiltro, areaInterestFiltro, activitiesPerformedFiltro, courseNameFiltro, roleNameFiltro, academicQualification_idFiltro);

		    }
	
		  		
}
		  
