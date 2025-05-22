package com.API_grupo_5.API_grupo_5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API_grupo_5.API_grupo_5.domain.Funcao;
import com.API_grupo_5.API_grupo_5.repository.FuncaoRepository;

@Service
public class FuncaoService {
    
    @Autowired
    private FuncaoRepository FuncaoRepository;

     // Obter todos as funçoes
     public List<Funcao> listarFuncao(){
        return(List<Funcao>) FuncaoRepository.findAll();
     }
 
     //Obter uma Funçao
     public Optional<Funcao> getFuncaoById(Long id) {
        return FuncaoRepository.findById(id);
     }

     // Incluir nova funçao
    public Funcao incluir(Funcao funcao){
        return FuncaoRepository.save(funcao);
    }

        // Atualizar uma funçao
    public Funcao atualizar(Long id, Funcao funcao) {
        if (FuncaoRepository.existsById(id)){
            funcao.setId(id);
            return FuncaoRepository.save(funcao);
        }
        return null;
    }
}
