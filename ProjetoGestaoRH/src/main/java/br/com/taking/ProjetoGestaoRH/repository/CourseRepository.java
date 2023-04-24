package br.com.taking.ProjetoGestaoRH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.taking.ProjetoGestaoRH.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
