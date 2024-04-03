package com.example.demo.controller;

import com.example.demo.model.Ave;
import com.example.demo.service.AveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aves")
public class AveController {

    private final AveService aveService;

    @Autowired
    public AveController(AveService aveService) {
        this.aveService = aveService;
    }

    @GetMapping
    public List<Ave> listarAves() {
        return aveService.listarAves();
    }

    @PostMapping
    public Ave criarAve(@Valid @RequestBody Ave ave) {
        return aveService.criarAve(ave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAve(@PathVariable Long id, @RequestBody Ave ave) {
        if (aveService.atualizarAve(id, ave) != null) {
            return ResponseEntity.ok(ave);
        } else {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAve(@PathVariable Long id) {
        if (aveService.deletarAve(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        } else {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/sem-voo")
    public ResponseEntity<List<Ave>> listarAvesNaoVoam() {
        List<Ave> avesSemVoo = aveService.listarAvesNaoVoam();
        return ResponseEntity.ok(avesSemVoo);
    }

    @GetMapping("/domesticas")
    public ResponseEntity<List<Ave>> listarAvesDomesticas() {
        List<Ave> avesDomesticas = aveService.listarAvesDomesticas();
        return ResponseEntity.ok(avesDomesticas);
    }

    @GetMapping("/quantidade")
    public ResponseEntity<Integer> quantidadeDeAves() {
        int quantidadeAves = aveService.quantidade();
        return ResponseEntity.ok(quantidadeAves);
    }

    @GetMapping("/media-idade")
    public ResponseEntity<Double> calcularMediaIdadeAves() {
        double mediaIdade = aveService.calcularMediaIdade();
        return ResponseEntity.ok(mediaIdade);
    }

}
