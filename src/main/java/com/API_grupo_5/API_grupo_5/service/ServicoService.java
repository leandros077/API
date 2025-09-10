package com.API_grupo_5.API_grupo_5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API_grupo_5.API_grupo_5.domain.Servico;
import com.API_grupo_5.API_grupo_5.repository.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository ServicoRepository;

    // Obter todos os Servicos
    public List<Servico>listaServicos(){
        return(List<Servico>)ServicoRepository.findAll();
    }

    // Obter um Servico
    public Optional<Servico> getServicoById(long id) {
        return ServicoRepository.findById(id);
    }

     // Incluir novo servico
     public Servico incluir(Servico servico){
        return ServicoRepository.save(servico);
     }

     // Atualizar um servico
     public Servico atualizar(Long id, Servico servico){
        if (ServicoRepository.existsById(id)) {
            servico.setServicoID(id);
            return ServicoRepository.save(servico);
        }
        return null;
     }
}
