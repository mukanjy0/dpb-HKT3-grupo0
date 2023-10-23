package com.example.sem11.periodo.application;

import com.example.sem11.periodo.domain.Periodo;
import com.example.sem11.periodo.domain.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/periodos")
public class PeriodoController {
    @Autowired
    private PeriodoRepository repository;
    @GetMapping
    public ResponseEntity<List<Periodo>> read() {
        List<Periodo> periodos = repository.findAll();
        return new ResponseEntity<>(periodos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Periodo> read(@PathVariable Long id) {
        Optional<Periodo> periodo = repository.findById(id);
        return new ResponseEntity<>(periodo.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Periodo periodo) {
        repository.save(periodo);
        return ResponseEntity.status(201).body("Created periodo");
    }
}
