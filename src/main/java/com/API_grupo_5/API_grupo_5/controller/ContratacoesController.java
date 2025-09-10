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

import com.API_grupo_5.API_grupo_5.domain.Contratacoes;
import com.API_grupo_5.API_grupo_5.service.ContratacoesService;




@RestController
@RequestMapping("/api/zentec/funcao")
public class ContratacoesController {

    
    @Autowired
    private ContratacoesService service;

    @GetMapping
    public ResponseEntity<List<Contratacoes>> listarUser(){
        return new ResponseEntity<>(service.listarFuncao(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Contratacoes> get(@PathVariable("id") Long id) {
        return service.getFuncaoById(id);
    }

    @PostMapping
    public ResponseEntity<Contratacoes> incluir(@RequestBody Contratacoes funcao) {
        Contratacoes novaFuncao = service.incluir(funcao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaFuncao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contratacoes> atualizar(@PathVariable Long id , @RequestBody Contratacoes funcao){
        Contratacoes FuncaoAtualizado = service.atualizar(id, funcao);
        if (FuncaoAtualizado != null) {
            return ResponseEntity.ok(FuncaoAtualizado);
            
        }
        return ResponseEntity.notFound().build();
    }   
}


    

