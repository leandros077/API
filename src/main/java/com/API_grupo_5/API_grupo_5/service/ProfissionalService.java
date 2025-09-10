package com.API_grupo_5.API_grupo_5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API_grupo_5.API_grupo_5.domain.Profissional;
import com.API_grupo_5.API_grupo_5.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
    
    @Autowired
    private ProfissionalRepository ProfissionalRepository;

    // Obter todos os Usuarios
    public List<Profissional> listarProfissionals(){
        return(List<Profissional>) ProfissionalRepository.findAll();
    }

    // Obter um Usuario
    public Optional<Profissional> getProfissionalById(long id) {
        return ProfissionalRepository.findById(id);
    }

    // Incluir novo usuario
    public Profissional incluir(Profissional profissional){
        return ProfissionalRepository.save(profissional); 
    }

    // Atualizar um produto
    public Profissional atualizar(Long id, Profissional profissional) {
        if (ProfissionalRepository.existsById(id)){
            profissional.setProfissionalID(id);
            return ProfissionalRepository.save(profissional);

        }
        return null;
    }
}
