package com.API_grupo_5.API_grupo_5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.API_grupo_5.API_grupo_5.domain.User;
import com.API_grupo_5.API_grupo_5.service.UserService;



@RestController
@RequestMapping("/api/zentec/user")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> listarUser(){
        return new ResponseEntity<>(service.listarUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<User> get(@PathVariable("id") Long id) {
        return service.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<User> incluir(@RequestBody User user) {
        User novoUser = service.incluir(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Long id , @RequestBody User user){
        User UserAtualizado = service.atualizar(id, user);
        if (UserAtualizado != null) {
            return ResponseEntity.ok(UserAtualizado);
            
        }
        return ResponseEntity.notFound().build();
    }  
     @DeleteMapping("/{id}")
    public ResponseEntity<User> excluir(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    } 
}

