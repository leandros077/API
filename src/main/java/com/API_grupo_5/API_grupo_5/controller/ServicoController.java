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

import com.API_grupo_5.API_grupo_5.domain.Servico;
import com.API_grupo_5.API_grupo_5.service.ServicoService;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity<List<Servico>> ListarServico(){
        return new ResponseEntity<>(service.listaServicos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Servico> get(@PathVariable("id") Long id){
        return service.getServicoById(id);
    }

    @PostMapping
    public ResponseEntity<Servico> incluir(@RequestBody Servico servico){
        Servico novoServico = service.incluir(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id , @RequestBody Servico servico){
        Servico ServicoAtualizado = service.atualizar(id, servico);
        if (ServicoAtualizado != null){
            return ResponseEntity.ok(ServicoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
