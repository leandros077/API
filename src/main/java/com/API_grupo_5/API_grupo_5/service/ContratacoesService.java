package com.API_grupo_5.API_grupo_5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API_grupo_5.API_grupo_5.domain.Contratacoes;
import com.API_grupo_5.API_grupo_5.repository.ContratacoesRepository;

@Service
public class ContratacoesService {
    
    @Autowired
    private ContratacoesRepository FuncaoRepository;

     // Obter todos as funçoes
     public List<Contratacoes> listarFuncao(){
        return(List<Contratacoes>) FuncaoRepository.findAll();
     }
 
     //Obter uma Funçao
     public Optional<Contratacoes> getFuncaoById(Long id) {
        return FuncaoRepository.findById(id);
     }

     // Incluir nova funçao
    public Contratacoes incluir(Contratacoes funcao){
        return FuncaoRepository.save(funcao);
    }

        // Atualizar uma funçao
    public Contratacoes atualizar(Long id, Contratacoes funcao) {
        if (FuncaoRepository.existsById(id)){
            funcao.setContratacaoID(id);
            return FuncaoRepository.save(funcao);
        }
        return null;
    }
}
