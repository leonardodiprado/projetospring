package com.example.demo.service;

import com.example.demo.model.Ave;
import com.example.demo.repository.AveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AveService implements AnimalService {

    private final AveRepository aveRepository;

    @Autowired
    public AveService(AveRepository aveRepository) {
        this.aveRepository = aveRepository;
    }

    public List<Ave> listarAves() {
        return aveRepository.findAll();
    }

    public Ave criarAve(Ave ave) {
        return aveRepository.save(ave);
    }

    public Ave atualizarAve(Long id, Ave ave) {
        Optional<Ave> optionalAve = aveRepository.findById(id);
        if (optionalAve.isPresent()) {
            ave.setId(id);
            return aveRepository.save(ave);
        }
        return null;
    }

    public boolean deletarAve(Long id) {
        if (aveRepository.existsById(id)) {
            aveRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Ave> listarAvesNaoVoam() {
        return aveRepository.findByCapacidadeVooIgnoreCase("nao voa");
    }

    public List<Ave> listarAvesDomesticas() {
        return aveRepository.findByDomesticaTrue();
    }

    @Override
    public int quantidade() {
        return (int) aveRepository.count();
    }

    @Override
    public double calcularMediaIdade() {
        List<Ave> aves = aveRepository.findAll();
        int totalIdade = aves.stream().mapToInt(Ave::getIdade).sum();
        return aves.isEmpty() ? 0 : (double) totalIdade / aves.size();
    }
}
