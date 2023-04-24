package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Academic_qualification;
import br.com.taking.ProjetoGestaoRH.repository.Academic_qualificationRepository;

@Service
public class Academic_qualificationServiceImpl implements Academic_qualificationService{

	     @Autowired
		Academic_qualificationRepository academicRepository;
		
	 
	     @Override
		public List<Academic_qualification> listarTodos() {
			
			return academicRepository.findAll();
		}
		

		@Override
		public Academic_qualification incluir(Academic_qualification academic) {
			
			return academicRepository.save(academic);
		}

		@Override
		public Academic_qualification obterPorId(int id) {
			Optional<Academic_qualification> result =  academicRepository.findById(id);
			if(result.isPresent()) {
				return result.get();
			}else {
				return null;
			}

		}

		@Override
		public Academic_qualification atualizar(int id, Academic_qualification academicNew) {
		                  Optional<Academic_qualification> resultBD = academicRepository.findById(id); 
		                  if(resultBD.isPresent()) {
		                	 Academic_qualification academicBD =  resultBD.get();
	                         academicBD.setFormation(academicNew.getFormation());
		                	 academicBD.setInstitution(academicNew.getInstitution());
		                	 academicBD.setCourse(academicNew.getCourse());
		                	 academicBD.setStatus(academicNew.getStatus());
		                	 academicBD.setStartMonth(academicNew.getEndMonth());
		                	 academicBD.setStartYear(academicNew.getStartYear());	 
		                	 academicBD.setEndMonth(academicNew.getEndMonth());
		                	 academicBD.setEndYear(academicNew.getEndYear());
		                	   return academicRepository.save(academicBD);
		                  }else {
		       			       return null;

		   }
		}               

		@Override
		public void deletar(int id) {
			academicRepository.deleteById(id);
		}
}