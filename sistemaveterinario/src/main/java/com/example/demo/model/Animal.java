package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

@MappedSuperclass
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do animal não pode estar em branco")
    private String nome;

    @Min(value = 0, message = "A idade do animal não pode ser negativa.")
    private int idade;

    private String racaEspecie;

    public Animal() {
    }

    public Animal(String nome, int idade, String racaEspecie) {
        this.nome = nome;
        this.idade = idade;
        this.racaEspecie = racaEspecie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRacaEspecie() {
        return racaEspecie;
    }

    public void setRacaEspecie(String racaEspecie) {
        this.racaEspecie = racaEspecie;
    }

}
