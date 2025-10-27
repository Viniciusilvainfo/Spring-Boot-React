package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;

    public String getNome(){
        return nome;
    }

    public Double getPreco(){
        return preco;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }
}