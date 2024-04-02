package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Cachorro extends Animal {
    @NotBlank(message = "A cor da pelagem não pode estar em branco")
    private String corPelagem;

    public Cachorro() {
    }

    public Cachorro(String nome, int idade, String racaEspecie, String corPelagem) {
        super(nome, idade, racaEspecie);
        this.corPelagem = corPelagem;
    }

    public String getCorPelagem() {
        return corPelagem;
    }

    public void setCorPelagem(String corPelagem) {
        this.corPelagem = corPelagem;
    }

}
