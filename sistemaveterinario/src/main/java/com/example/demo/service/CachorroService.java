package com.example.demo.service;

import com.example.demo.model.Cachorro;
import com.example.demo.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CachorroService implements AnimalService {

    private final CachorroRepository cachorroRepository;

    @Autowired
    public CachorroService(CachorroRepository cachorroRepository) {
        this.cachorroRepository = cachorroRepository;
    }

    public List<Cachorro> listarCachorros() {
        return cachorroRepository.findAll();
    }

    public Cachorro criarCachorro(Cachorro cachorro) {
        return cachorroRepository.save(cachorro);
    }

    public Cachorro atualizarCachorro(Long id, Cachorro cachorro) {
        Optional<Cachorro> optionalCachorro = cachorroRepository.findById(id);
        if (optionalCachorro.isPresent()) {
            cachorro.setId(id);
            return cachorroRepository.save(cachorro);
        }
        return null;
    }

    public boolean deletarCachorro(Long id) {
        if (cachorroRepository.existsById(id)) {
            cachorroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean verificarSeEhFilhote(Long id) {
        Optional<Cachorro> optionalCachorro = cachorroRepository.findById(id);
        return optionalCachorro.map(cachorro -> cachorro.getIdade() < 1).orElse(false);
    }

    public int calcularIdadeEmAnosHumanos(Long id) {
        Optional<Cachorro> optionalCachorro = cachorroRepository.findById(id);
        return optionalCachorro.map(cachorro -> cachorro.getIdade() * 7).orElse(-1);
    }

    public List<Cachorro> listarCachorrosComPelagemBranca() {
        return cachorroRepository.findByCorPelagemIgnoreCase("branco");
    }

    @Override
    public int quantidade() {
        return (int) cachorroRepository.count();
    }

    @Override
    public double calcularMediaIdade() {
        List<Cachorro> cachorros = cachorroRepository.findAll();
        int totalIdade = cachorros.stream().mapToInt(Cachorro::getIdade).sum();
        return cachorros.isEmpty() ? 0 : (double) totalIdade / cachorros.size();
    }
}
