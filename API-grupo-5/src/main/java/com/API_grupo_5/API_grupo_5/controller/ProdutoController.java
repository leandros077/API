package com.API_grupo_5.API_grupo_5.controller;

import java.util.Optional;
import java.util.List;

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

import com.API_grupo_5.API_grupo_5.domain.Produto;
import com.API_grupo_5.API_grupo_5.service.ProdutosService;



@RestController
@RequestMapping("/api/zentec/produtos")
public class ProdutoController {
      @Autowired
    private ProdutosService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return new ResponseEntity<>(service.listarProdutos(), HttpStatus.OK);
    }

    
    // aula semana 09-13/09

    @GetMapping("/{id}")
    public Optional<Produto> get(@PathVariable("id") Long id) {
        return service.getProdutoById(id);
    }

    // Incluir novo produto
    @PostMapping
    public ResponseEntity<Produto> incluir(@RequestBody Produto produto) {
        Produto novoProduto = service.incluir(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }
@PutMapping("/{id}")
public ResponseEntity<Produto> atualizar(@PathVariable Long id , @RequestBody Produto produto){
    Produto produtoAtualizado = service.atualizar(id, produto);
    if (produtoAtualizado != null){
        return ResponseEntity.ok(produtoAtualizado);
    }
    return ResponseEntity.notFound().build();
}
} 

