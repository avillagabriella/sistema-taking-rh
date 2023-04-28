package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;


import br.com.taking.ProjetoGestaoRH.model.Candidato;

public interface CandidatoService {

    List<Candidato> listarTodos();

    Candidato incluir(Candidato candidato);

    Candidato obterPorId(int id);

    Candidato atualizar(int id, Candidato newCandidato);

    void deletar(int id);

    List<Candidato> findByIdentificationDocument(String identification);

    List<Candidato> findByFirstName(String firtName);

    List<Candidato> findByAge(Integer age);

    List<Candidato> findByAges(Integer age1, Integer age2);

    List<Candidato> findByLanguage(String language);
}