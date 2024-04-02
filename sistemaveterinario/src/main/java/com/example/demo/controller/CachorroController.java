package com.example.demo.controller;

import com.example.demo.model.Cachorro;
import com.example.demo.service.CachorroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cachorros")
public class CachorroController {

    @Autowired
    CachorroService cachorroService;

    @GetMapping
    public List<Cachorro> listarCachorros() {
        return cachorroService.listarCachorros();
    }

    @PostMapping
    public Cachorro criarCachorro(@Valid @RequestBody Cachorro cachorro) {
        return cachorroService.criarCachorro(cachorro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCachorro(@PathVariable Long id, @RequestBody Cachorro cachorro) {
        if (cachorroService.atualizarCachorro(id, cachorro) != null) {
            return ResponseEntity.ok(cachorro);
        } else {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCachorro(@PathVariable Long id) {
        if(cachorroService.deletarCachorro(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/{id}/verificar-filhote")
    public ResponseEntity<String> verificarFilhote(@PathVariable Long id) {
        if(cachorroService.verificarSeEhFilhote(id)) {
            return ResponseEntity.ok("O cachorro é um filhote.");
        } else {
            return ResponseEntity.ok("O cachorro não é um filhote.");
        }
    }

    @GetMapping("/{id}/idade-anos-humanos")
    public ResponseEntity<Integer> calcularIdadeEmAnosHumanos(@PathVariable Long id) {
        int idadeEmAnosHumanos = cachorroService.calcularIdadeEmAnosHumanos(id);
        if (idadeEmAnosHumanos >= 0) {
            return ResponseEntity.ok(idadeEmAnosHumanos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pelos-brancos")
    public ResponseEntity<List<Cachorro>> listarCachorrosComPelagemBranca() {
        List<Cachorro> cachorros = cachorroService.listarCachorrosComPelagemBranca();
        return ResponseEntity.ok(cachorros);
    }

    @GetMapping("/quantidade")
    public ResponseEntity<Integer> quantidadeDeCachorros() {
        int quantidadeCachorros = cachorroService.quantidade();
        return ResponseEntity.ok(quantidadeCachorros);
    }

    @GetMapping("/media-idade")
    public ResponseEntity<Double> calcularMediaIdadeCachorros() {
        double mediaIdade = cachorroService.calcularMediaIdade();
        return ResponseEntity.ok(mediaIdade);
    }




}