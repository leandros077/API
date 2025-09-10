package com.API_grupo_5.API_grupo_5.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Servicos")
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ServicoID ;

    @Column(name = "ProfissionalID")
    private String profissionalID ;

    private String Titulo;
    @Column

    private String Descricao;
     @Column

    private String Preco; 
     @Column

    private String DataCriacao;
    


}
