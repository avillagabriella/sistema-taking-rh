package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.State;

import br.com.taking.ProjetoGestaoRH.repository.StateRepository;

@Service
public class StateServiceimpl implements StateService{
	
		
	@Autowired
	StateRepository stateRepository;
	

	@Override
	public List<State> listarTodos() {
	
		return stateRepository.findAll();
	}

   
	@Override
	public State incluir(State state) {
		return stateRepository.save(state);
		

	}
	

	@Override
	public State atualizar(int id, State stateNew) {
		Optional<State> result = stateRepository.findById(id);
		if(result.isPresent()) {
		State stateBD = result.get();
		stateBD.setCountry(stateNew.getCountry());
		stateBD.setState(stateNew.getState());
	
		return stateRepository.save(stateBD);
		}else {
			return null;
		}
	}


	
	@Override
	public void deletar(int id) {
		 stateRepository.deleteById(id);
		
	}



	@Override
	public State obterPorId(int id) {
		Optional<State> result = stateRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
			}else {
				return null;
			}

	}
}
