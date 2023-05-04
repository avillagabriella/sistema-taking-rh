package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;

import br.com.taking.ProjetoGestaoRH.model.State;
import br.com.taking.ProjetoGestaoRH.model.Status;

public interface StateService {
	
	List<State> listarTodos();

	State  incluir(State state);
	
	State  obterPorId(int id);
	
	State atualizar(int id, State StateNew);
	
	void deletar (int id);

}
