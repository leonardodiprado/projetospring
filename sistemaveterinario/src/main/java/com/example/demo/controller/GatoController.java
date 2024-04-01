package com.example.demo.controller;

import com.example.demo.model.Gato;
import com.example.demo.service.GatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gatos")
public class GatoController {

    @Autowired
    GatoService gatoService;

    @GetMapping
    public List<Gato> listarGatos() {
        return gatoService.listarGatos();
    }

    @GetMapping("/mediaidade")
    public ResponseEntity<Double> calcularMediaIdade() {
        double idadeMedia = gatoService.calcularMediaIdade();
        return ResponseEntity.ok(idadeMedia);
    }

    @PostMapping
    public Gato criarGato(@Valid @RequestBody Gato gato) {
        return gatoService.criarGato(gato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarGato(@PathVariable Long id, @RequestBody Gato gato) {
        if (gatoService.atualizarGato(id, gato) != null) {
            return ResponseEntity.ok(gato);
        } else {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarGato(@PathVariable Long id) {
        if(gatoService.deletarGato(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
}
