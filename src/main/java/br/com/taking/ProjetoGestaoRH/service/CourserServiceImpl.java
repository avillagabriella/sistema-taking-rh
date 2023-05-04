package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Course;
import br.com.taking.ProjetoGestaoRH.repository.CourseRepository;

@Service
public class CourserServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository courseRepository;
	

	@Override
	public List<Course> listarTodos() {
	
		return courseRepository.findAll();
	}


	@Override
	public Course incluir(Course course) {
	    return courseRepository.save(course);
	}


	@Override
	public Course obterPorId(int id) {
	Optional<Course> result = 	courseRepository.findById(id);
	 if(result.isPresent()) {
		 return result.get();
	 }else {
		 return null;
	 }
	}


	@Override
	public Course atualizar(int id, Course courseNew) {
		Optional<Course> result = 	courseRepository.findById(id);
		if(result.isPresent()) {
			Course courseBD =  result.get();
			courseBD.setCourseName(courseNew.getCourseName());
			return courseRepository.save(courseBD);
		}else {
			return null;
		}
	}


	@Override
	public void deletar(int id) {
		courseRepository.deleteById(id);
		
	}

}
