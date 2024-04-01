package com.example.demo.service;

import com.example.demo.model.Cachorro;
import com.example.demo.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CachorroService {

    private final CachorroRepository cachorroRepository;

    @Autowired
    public CachorroService(CachorroRepository cachorroRepository) {
        this.cachorroRepository = cachorroRepository;
    }

    public List<Cachorro> getAllCachorros() {
        return cachorroRepository.findAll();
    }

    public long contarTotalCachorros() {
        return cachorroRepository.count();
    }

    public Optional<Cachorro> getCachorroById(Long id) {
        return cachorroRepository.findById(id);
    }

    public Cachorro criarCachorro(Cachorro cachorro) {
        return cachorroRepository.save(cachorro);
    }

    public Cachorro atualizarCachorro(Long id, Cachorro cachorro) {
        Optional<Cachorro> optionalCachorro = getCachorroById(id);
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

    public List<Cachorro> listarCachorros() {
        return cachorroRepository.findAll();
    }
}

