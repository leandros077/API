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

import com.API_grupo_5.API_grupo_5.domain.Funcao;
import com.API_grupo_5.API_grupo_5.service.FuncaoService;




@RestController
@RequestMapping("/api/zentec/funcao")
public class FuncaoController {

    
    @Autowired
    private FuncaoService service;

    @GetMapping
    public ResponseEntity<List<Funcao>> listarUser(){
        return new ResponseEntity<>(service.listarFuncao(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Funcao> get(@PathVariable("id") Long id) {
        return service.getFuncaoById(id);
    }

    @PostMapping
    public ResponseEntity<Funcao> incluir(@RequestBody Funcao funcao) {
        Funcao novaFuncao = service.incluir(funcao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaFuncao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcao> atualizar(@PathVariable Long id , @RequestBody Funcao funcao){
        Funcao FuncaoAtualizado = service.atualizar(id, funcao);
        if (FuncaoAtualizado != null) {
            return ResponseEntity.ok(FuncaoAtualizado);
            
        }
        return ResponseEntity.notFound().build();
    }   
}


    

