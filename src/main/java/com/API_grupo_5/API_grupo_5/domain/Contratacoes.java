package com.API_grupo_5.API_grupo_5.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Contratacoes")
@Data
public class Contratacoes {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long ContratacaoID ; 
   
   @Column(name = "ClienteID")
   private String ClienteID;
   
   @Column(name = "ServicoID")   
   private String ServicoID ;
 

   private String DataContratacao ;
   @Column

   private String Status ;
   
  
}

