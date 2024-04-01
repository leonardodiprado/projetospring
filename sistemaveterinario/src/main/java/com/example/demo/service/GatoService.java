package com.example.demo.service;

import com.example.demo.model.Gato;
import com.example.demo.repository.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GatoService {

    private final GatoRepository gatoRepository;

    @Autowired
    public GatoService(GatoRepository gatoRepository) {
        this.gatoRepository = gatoRepository;
    }

    public List<Gato> getAllGatos() {
        return gatoRepository.findAll();
    }

    public double calcularMediaIdade() {
        List<Gato> gatos = gatoRepository.findAll();
        if (gatos.isEmpty()) {
            return 0;
        }

        int totalIdade = gatos.stream().mapToInt(gato -> Integer.parseInt(String.valueOf(gato.getIdade()))).sum();
        return (double) totalIdade / gatos.size();
    }

    public Optional<Gato> getGatoById(Long id) {
        return gatoRepository.findById(id);
    }

    public Gato criarGato(Gato gato) {
        return gatoRepository.save(gato);
    }

    public Gato atualizarGato(Long id, Gato gato) {
        Optional<Gato> optionalGato = getGatoById(id);
        if (optionalGato.isPresent()) {
            gato.setId(id);
            return gatoRepository.save(gato);
        }
        return null;
    }

    public boolean deletarGato(Long id) {
        if (gatoRepository.existsById(id)) {
            gatoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Gato> listarGatos() {
        return gatoRepository.findAll();
    }
}
