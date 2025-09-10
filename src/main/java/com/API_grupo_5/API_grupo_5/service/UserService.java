package com.API_grupo_5.API_grupo_5.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.API_grupo_5.API_grupo_5.domain.User;
import com.API_grupo_5.API_grupo_5.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    // Obter todos os Usuarios
    public List<User> listarUsers(){
        return(List<User>) UserRepository.findAll();
    }

    // Obter um Usuario
    public Optional<User> getUserById(Long id) {
        return UserRepository.findById(id);
    }

    // Incluir novo usuario
    public User incluir(User user){
        return UserRepository.save(user);
    }


    // Atualizar um produto
    public User atualizar(Long id, User user) {
        if (UserRepository.existsById(id)){
            user.setClienteID(id);
            return UserRepository.save(user);
        }
        return null;
    }

}















    

