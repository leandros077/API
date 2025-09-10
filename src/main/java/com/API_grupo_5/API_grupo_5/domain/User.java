package com.API_grupo_5.API_grupo_5.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Clientes")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ClienteID ;

    private String Nome;
    @Column

    private String CPF;
    @Column

    
    private String Email;
    @Column

    private String Telefone;
    @Column

    private String Endereco;
    @Column

    private String Senha;
    @Column

    
    private String DataCadastro;
    
}
