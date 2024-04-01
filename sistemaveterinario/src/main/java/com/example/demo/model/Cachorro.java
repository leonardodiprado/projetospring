package com.example.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Cachorro extends Animal {
    private String corPelagem;
    private String porte;
    private String raca;

    public Cachorro() {
    }

    public Cachorro(String nome, int idade, int cpfProprietario, String corPelagem, String porte, String raca) {
        super(nome, idade, cpfProprietario);
        this.corPelagem = corPelagem;
        this.porte = porte;
        this.raca = raca;
    }

    @Override
    public String emitirSom() {
        return "Au Au!";
    }

    @Override
    public void realizarExame() {
        System.out.println("Cachorro realizando exame...");
    }

    @Override
    public void aplicarMedicacao() {
        System.out.println("Cachorro recebendo medicação...");
    }

    @Override
    public void realizarCirurgia() {
        System.out.println("Cachorro passando por cirurgia...");
    }


    public String getCorPelagem() {
        return corPelagem;
    }

    public void setCorPelagem(String corPelagem) {
        this.corPelagem = corPelagem;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}