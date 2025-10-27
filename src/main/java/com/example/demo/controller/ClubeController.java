package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Clube;
import com.example.demo.repository.ClubeRepository;

import java.util.List;

@RestController
@RequestMapping("/clubes")
@CrossOrigin(origins = "http://localhost:3000") // ✅ Permite requisições do React
public class ClubeController {

    private final ClubeRepository repository;

    public ClubeController(ClubeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Clube> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Clube criar(@RequestBody Clube clube) {
        return repository.save(clube);
    }

    @GetMapping("/{id}")
    public Clube buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Clube atualizar(@PathVariable Long id, @RequestBody Clube novo) {
        Clube clube = repository.findById(id).orElseThrow();
        clube.setNome(novo.getNome());
        clube.setPreco(novo.getPreco());
        return repository.save(clube);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
