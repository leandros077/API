package com.API_grupo_5.API_grupo_5.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Funcao")
@Data
public class Funcao {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ; 
   
   private String nome;
   @Column

   private int categoria_id;
}
