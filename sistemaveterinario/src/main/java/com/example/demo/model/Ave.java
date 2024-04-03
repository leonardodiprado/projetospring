package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ave extends Animal {
    @NotBlank(message = "A capacidade de voo não pode estar em branco")
    private String capacidadeVoo;
    @NotNull(message = "O campo 'doméstica' deve ser fornecido")
    private boolean domestica;

    public Ave() {
    }

    public Ave(String nome, int idade, String racaEspecie, String capacidadeVoo, boolean domestica) {
        super(nome, idade, racaEspecie);
        this.capacidadeVoo = capacidadeVoo;
        this.domestica = domestica;
    }

    public String getCapacidadeVoo() {
        return capacidadeVoo;
    }

    public void setCapacidadeVoo(String capacidadeVoo) {
        this.capacidadeVoo = capacidadeVoo;
    }

    public boolean isDomestica() {
        return domestica;
    }

    public void setDomestica(boolean domestica) {
        this.domestica = domestica;
    }

}
