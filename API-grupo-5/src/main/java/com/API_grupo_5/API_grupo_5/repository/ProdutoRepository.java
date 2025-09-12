package com.API_grupo_5.API_grupo_5.repository;

import org.springframework.data.repository.CrudRepository;

import com.API_grupo_5.API_grupo_5.domain.Produto;

public interface ProdutoRepository  extends CrudRepository<Produto,Long>  {
    
}
