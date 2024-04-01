package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Animal implements ProcedimentoMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private int cpfProprietario;

    public Animal() {
    }

    public Animal(String nome, int idade, int cpfProprietario) {
        if (!validarNome(nome)) {
            System.out.println("O nome do animal não pode estar em branco");
            return;
        }
        if (!validarIdade(idade)) {
            System.out.println("A idade do animal não pode ser negativa.");
            return;
        }
        if (!validarCpfProprietario(cpfProprietario)) {
            return;
        }
        this.nome = nome;
        this.idade = idade;
        this.cpfProprietario = cpfProprietario;
    }

    public abstract String emitirSom();

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
        if (validarNome(nome)) {
            this.nome = nome;
        } else {
            System.out.println("O nome do animal não pode estar em branco");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (validarIdade(idade)) {
            this.idade = idade;
        } else {
            System.out.println("A idade do animal não pode ser negativa.");
        }
    }

    public int getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(int cpfProprietario) {
        if (validarCpfProprietario(cpfProprietario)) {
            this.cpfProprietario = cpfProprietario;
        } else {
            System.out.println("O CPF do proprietário não pode ser negativo.");
        }
    }

    private boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    private boolean validarIdade(int idade) {
        return idade >= 0;
    }

    private boolean validarCpfProprietario(int cpfProprietario) {
        return cpfProprietario >= 0;
    }
}