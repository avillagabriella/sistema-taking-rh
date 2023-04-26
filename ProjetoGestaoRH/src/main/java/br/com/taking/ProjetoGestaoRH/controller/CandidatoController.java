package br.com.taking.ProjetoGestaoRH.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.taking.ProjetoGestaoRH.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.taking.ProjetoGestaoRH.model.Candidato;
import br.com.taking.ProjetoGestaoRH.service.CandidatoService;

@RestController
public class CandidatoController {

    @Autowired
    CandidatoService candidatoService;

    @Autowired
    private CandidatoRepository candidatoRepository;

    @RequestMapping(value = "/candidato", method = RequestMethod.GET)
    public ResponseEntity<List<Candidato>> GetALL() {
        List<Candidato> resultado = candidatoService.listarTodos();
        return new ResponseEntity<List<Candidato>>(resultado, HttpStatus.OK);
    }

    //INCLUIR
    @RequestMapping(value = "/candidato", method = RequestMethod.POST)
    public Candidato Post(@RequestBody Candidato candidato) {
        return candidatoService.incluir(candidato);
    }

    //OBTER POR ID
    @RequestMapping(value = "/candidato/{id}", method = RequestMethod.GET)
    public ResponseEntity<Candidato> GetById(@PathVariable(value = "id") int id) {
        Candidato candidato = candidatoService.obterPorId(id);
        if (candidato != null) {
            return new ResponseEntity<Candidato>(candidato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    // ATUALIZAR
    @RequestMapping(value = "/candidato/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Candidato> Put(@PathVariable(value = "id") int id, @RequestBody Candidato candidato) {
        Candidato candidatoAtualizado = candidatoService.atualizar(id, candidato);

        if (candidatoAtualizado != null) {
            return new ResponseEntity<Candidato>(candidatoAtualizado, HttpStatus.OK);

        } else {
            return new ResponseEntity<Candidato>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETAR
    @RequestMapping(value = "/candidato/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id) {
        Candidato cliente = candidatoService.obterPorId(id);
        if (cliente != null) {
            candidatoService.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //FILTRO Documento
    @RequestMapping(value = "/candidato/filter{identificationDocument}", method = RequestMethod.POST)
    public ResponseEntity<List<Candidato>> FindByIdentification(@PathVariable(value = "identificationDocument") String identification) {
        List<Candidato> candidato = candidatoService.findByIdentificationDocument(identification);
        if (candidato != null) {
            return new ResponseEntity<>(candidato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Filtrar o candidato enviando a idade especifica no header
     * @param age idade escolhida pelo usuario
     * @return
     */
    @RequestMapping(value = "/candidato/filter/age/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<Candidato>> FilterAge(@PathVariable(value = "age") int age) {
        List<Candidato> candidato = candidatoRepository.filterDate(age);
        if (candidato.size() > 0)
            return new ResponseEntity<>(candidato, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Filtrar o candidato enviando duas idades no header
     * @param age1 primeira idade escolhida pelo usuario
     * @param age2 segunda idade escolhida pelo usuario
     * @return
     */
    @RequestMapping(value = "/candidato/filter/ages/{age1}/{age2}", method = RequestMethod.GET)
    public ResponseEntity<List<Candidato>> FilterAge(@PathVariable(value = "age1") int age1, @PathVariable(value = "age2") int age2) {
        List<Candidato> candidato = candidatoRepository.filterAges(age1, age2);
        if (candidato.size() > 0)
            return new ResponseEntity<>(candidato, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Filtrar o candidato por Idioma enviando no header
     * @param language Lingua escolhida pelo usuario para filtrar
     * @return
     */
    @RequestMapping(value = "/candidato/filter/languages/{language}", method = RequestMethod.GET)
    public ResponseEntity<List<Candidato>> FilterLanguage(@PathVariable(value = "language") String language) {
        List<Candidato> candidato = candidatoRepository.filterLanguages(language);
        if (candidato.size() > 0)
            return new ResponseEntity<>(candidato, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Filtrar o candidato por Idioma e o Nivel do Idioma enviando no header
     * @param language Lingua escolhida pelo usuario para filtrar
     * @param level Nivel escolhida pelo usuario para filtrar
     * @return
     */
    @RequestMapping(value = "/candidato/filter/languages/{language}/{level}", method = RequestMethod.GET)
    public ResponseEntity<List<Candidato>> FilterLanguageWithLevel(@PathVariable(value = "language") String language, @PathVariable(value = "level") String level) {
        List<Candidato> candidato = candidatoRepository.filterLanguages(language);
        List<Candidato> list_return = new ArrayList<>();
        for (Candidato languageLevel : candidato)
            if (languageLevel.getLanguagesskill_id().stream().toList().get(0).getLevel().getLevelName().equals(level))
                list_return.add(languageLevel);

        if (list_return.size() > 0)
            return new ResponseEntity<>(list_return, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
		  
