package com.API_grupo_5.API_grupo_5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


@RequestMapping("/")
public class IndexController {
   
    @GetMapping
    public String hello(){
        return "EStou na API zentc-Grupo 5";
    }
}
