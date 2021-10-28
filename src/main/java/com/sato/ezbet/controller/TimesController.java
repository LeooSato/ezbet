package com.sato.ezbet.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.sato.ezbet.model.Times;
import com.sato.ezbet.repository.TimesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/times")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TimesController {
    
    @Autowired
    private TimesRepository TimesRepository;

    // @GetMapping("/{id}")
    // private ResponseEntity<Times> getById(@PathVariable Integer id) {
    //     return TimesRepository.findByID(id)
    //             .map(resp -> ResponseEntity.ok(resp))
    //             .orElse(ResponseEntity.notFound().build());
    // }

    @GetMapping("/all")
    private ResponseEntity<List<Times>> getAll() {
        return ResponseEntity.ok(TimesRepository.findAll());
    }

    @GetMapping("/{nomeTimes}")
    private ResponseEntity<List<Times>> getByPalavraChave(@PathVariable String nomeorg) {
        return ResponseEntity.ok(TimesRepository.findAllBynomeorgContainingIgnoreCase(nomeorg));
    }

    //Cadastrar
    @PostMapping("/cadastrar")
    public ResponseEntity<Times> post(@RequestBody Times Times) {
        return ResponseEntity.status(HttpStatus.CREATED).body(TimesRepository.save(Times));
    }
    //Alterar Postagem
    @PutMapping("/atualizar")
    public ResponseEntity<Times> put(@RequestBody Times Times) {
        return ResponseEntity.status(HttpStatus.OK).body(TimesRepository.save(Times));
    }
    //Deletar Postagem
    @DeleteMapping("/{id}")
    public void getId(@PathVariable long id) {
        TimesRepository.deleteById(id);
    }
}
