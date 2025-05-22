package com.API_grupo_5.API_grupo_5.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nome;
    @Column

    private String Email;
    @Column

    private String Senha;
    @Column

    private String Telefone;
    @Column

    private int categoria_id ;
    
}
