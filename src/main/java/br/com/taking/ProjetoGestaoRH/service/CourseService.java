package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import br.com.taking.ProjetoGestaoRH.model.Course;

public interface CourseService {
	
	List<Course> listarTodos();
	
   Course incluir(Course course);
	
   Course obterPorId(int id);
	
   Course atualizar(int id, Course courseNew);
	
	void deletar (int id);
     

}
