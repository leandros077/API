package com.API_grupo_5.API_grupo_5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API_grupo_5.API_grupo_5.domain.Produto;
import com.API_grupo_5.API_grupo_5.repository.ProtudoRepository;

@Service
public class ProdutosService {
     @Autowired
    private ProtudoRepository produtoRepository;

    // Obter todos os produtos
    public List<Produto> listarProdutos() {
        return (List<Produto>) produtoRepository.findAll();
    }

    
    
    // Obter um produto
    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    // Incluir novo produto
    public Produto incluir(Produto produto) {
        return produtoRepository.save(produto);
    }
   
    // Atualizar um produto 
    public Produto atualizar(Long id, Produto produto){
        if ( produtoRepository.existsById(id)){
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        return null;
    }

}
