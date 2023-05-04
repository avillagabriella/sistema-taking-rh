package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;

import br.com.taking.ProjetoGestaoRH.model.Level;

public interface LevelService {
	
	List<Level> listarTodos();
	
    Level incluir(Level level);
	
	Level obterPorId(int id);
	
	Level atualizar(int id, Level levelNew);
	
	void deletar (int id);



}
