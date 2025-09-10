package com.API_grupo_5.API_grupo_5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API_grupo_5.API_grupo_5.domain.Profissional;
import com.API_grupo_5.API_grupo_5.service.ProfissionalService;



@RestController
@RequestMapping("/profissional")


public class ProfissionalController {
    
    @Autowired
    private ProfissionalService service;

    @GetMapping
    public ResponseEntity<List<Profissional>> listarProfissional(){
        return new ResponseEntity<>(service.listarProfissionals(), HttpStatus.OK);    
    }
    @GetMapping("/{id}")
    public Optional<Profissional> get(@PathVariable("id") Long id){
        return service.getProfissionalById(id);  
    }

    @PostMapping
    public ResponseEntity<Profissional> incluir(@RequestBody Profissional profissional) {
        Profissional novoProfissional = service.incluir(profissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfissional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Long id , @RequestBody Profissional profissional){
        Profissional ProfissionalAtualizado = service.atualizar(id, profissional);
        if (ProfissionalAtualizado != null) {
            return ResponseEntity.ok(ProfissionalAtualizado);
            
        }
        return ResponseEntity.notFound().build();
    }   
}
