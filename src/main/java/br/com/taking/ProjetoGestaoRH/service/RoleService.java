package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import br.com.taking.ProjetoGestaoRH.model.Role;

public interface RoleService {
	
	List<Role> listarTodos();
	

	Role incluir(Role role);
	
	Role obterPorId(int id);
	
	Role atualizar(int id,Role roleNew);
	
	void deletar (int id);



}
