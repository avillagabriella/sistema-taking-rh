package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Role;
import br.com.taking.ProjetoGestaoRH.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;
	

	@Override
	public List<Role> listarTodos() {
	
		return roleRepository.findAll();
	}


	@Override
	public Role incluir(Role role) {
		return roleRepository.save(role);
	}


	@Override
	public Role obterPorId(int id) {
	
	Optional<Role> result =	roleRepository.findById(id);
	 if(result.isPresent()) {
		return result.get();
	 }else {
		 return null;
	 }
	
	}


	@Override
	public Role atualizar(int id, Role roleNew) {
		Optional<Role> result =	roleRepository.findById(id);
		if(result.isPresent()) {
			Role roleBD = result.get();
			roleBD.setRoleName(roleNew.getRoleName());
			return roleRepository.save(roleBD);
		}else {
			return null;
		}
	}


	@Override
	public void deletar(int id) {
		roleRepository.deleteById(id);
		
	}


}
