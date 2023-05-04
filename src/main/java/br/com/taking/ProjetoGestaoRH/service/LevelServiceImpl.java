package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Level;
import br.com.taking.ProjetoGestaoRH.repository.LevelRepository;

@Service
public class LevelServiceImpl implements LevelService{
	
	@Autowired
	LevelRepository levelRepository;
	

	@Override
	public List<Level> listarTodos() {
	
		return levelRepository.findAll();
	}


	@Override
	public Level incluir(Level level) {
		return levelRepository.save(level);
	}


	@Override
	public Level obterPorId(int id) {
	Optional<Level> result =	levelRepository.findById(id);
	if(result.isPresent()) {
	 return	result.get();
	}else {
		return null;
	}
	}


	@Override
	public Level atualizar(int id, Level levelNew) {
		Optional<Level> result =	levelRepository.findById(id);
		if(result.isPresent()) {
			Level resultBD = result.get();
			resultBD.setLevelName(levelNew.getLevelName());
			return levelRepository.save(resultBD);
		}else {
			return null;
		}
	}


	@Override
	public void deletar(int id) {
		levelRepository.findById(id);
		
	}


}
