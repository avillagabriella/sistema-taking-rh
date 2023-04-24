package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;

import br.com.taking.ProjetoGestaoRH.model.Status;

public interface StatusService {
	
	List<Status> listarTodos();
	
	Status incluir(Status status);
	
	Status  obterPorId(int id);
	
	Status  atualizar(int id, Status StatusNew);
	
	void deletar (int id);


}