package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.taking.ProjetoGestaoRH.model.Candidato;
import br.com.taking.ProjetoGestaoRH.repository.CandidatoRepository;

@Service
public class CandidatoServiceImpl implements CandidatoService{

	
	@Autowired
	CandidatoRepository candidatoRepository;
	

	@Override
	public List<Candidato> listarTodos() {
	
		return candidatoRepository.findAll();
	}

	
	
	@Override
	public Candidato incluir(Candidato candidato) {
		
		return candidatoRepository.save(candidato);
	}


	@Override
	public Candidato obterPorId(int id) {
		
		Optional<Candidato> result = candidatoRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
			}else {
				return null;
			}
	}


	@Override
	public Candidato atualizar(int id, Candidato newCandidato) {

		Optional<Candidato> resultBD = candidatoRepository.findById(id);
		if(resultBD.isPresent()) {
			 Candidato candidatoBD = resultBD.get();
			
			 candidatoBD.setFirstName(newCandidato.getFirstName());
			 candidatoBD.setLastName(newCandidato.getLastName());
			 candidatoBD.setEmail(newCandidato.getEmail());
			 candidatoBD.setBirthdate(newCandidato.getBirthdate());
			 candidatoBD.setIdentificationDocument(newCandidato.getIdentificationDocument());
			 candidatoBD.setLinkedinProfileUrl(newCandidato.getLinkedinProfileUrl());
			 candidatoBD.setMobileNumber(newCandidato.getMobileNumber());
			 candidatoBD.setPhoneNumber(newCandidato.getPhoneNumber());
			 candidatoBD.setAddressZipCode(newCandidato.getAddressNumber());
			 candidatoBD.setAddressNumber(newCandidato.getAddressNumber());
			 candidatoBD.setAreaInterest(newCandidato.getArea_interest());
			 candidatoBD.setCity(newCandidato.getCity());
             candidatoBD.setCountry_Origin(newCandidato.getCountry_Origin());
             candidatoBD.setDisability(newCandidato.getDisability());
             candidatoBD.setGender(newCandidato.getGender());
             candidatoBD.setAddressStreet(newCandidato.getAddressStreet());
			 return candidatoRepository.save(candidatoBD);
		}else {
			   return null;
		   }
	}



	@Override
	public void deletar(int id) {
		candidatoRepository.deleteById(id);
		
	  }



	@Override
	public List<Candidato> findByIdentificationDocument(String identification) {
	if(identification != null) {
		return candidatoRepository.findAll(identification);
	}
		
		return candidatoRepository.findAll();
	}



	@Override
	public List<Candidato> findByFirstName(String firstName) {
		if(firstName != null) {
			return candidatoRepository.findAll(firstName);
		}
		return candidatoRepository.findAll();
		
			
			


	
	
	





	
	}	
}
