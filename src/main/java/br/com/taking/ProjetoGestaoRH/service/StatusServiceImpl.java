package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taking.ProjetoGestaoRH.model.Status;
import br.com.taking.ProjetoGestaoRH.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService{
	
	@Autowired
	StatusRepository statusRepository;
	

	@Override
	public List<Status> listarTodos() {
	
		return statusRepository.findAll();
	}


	@Override
	public Status incluir(Status status) {
		
		return statusRepository.save(status);
	}


	@Override
	public Status obterPorId(int id) {
	  Optional<Status> result = statusRepository.findById(id);
	   if(result.isPresent()){
		   return result.get();
		}else {
			return null;
		}

	}


	@Override
	public Status atualizar(int id, Status statusNew) {
		Optional<Status> result = statusRepository.findById(id);
		   if(result.isPresent()){
			   Status statusBD =  result.get();
			
			   statusBD.setStatusName(statusNew.getStatusName());
			 return statusRepository.save(statusBD);
	         }else {
		     return null;
	   }
	}


	@Override
	public void deletar(int id) {
	  statusRepository.deleteById(id);
		
	}

}

