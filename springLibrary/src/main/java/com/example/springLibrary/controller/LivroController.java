package com.example.springLibrary.controller;

import com.example.springLibrary.entity.Livro;
import com.example.springLibrary.entity.dto.LivroDTO;
import com.example.springLibrary.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping("/save")
    public ResponseEntity<Livro> saveLivro(@RequestBody LivroDTO livroDTO){
        Livro livro = livroService.save(livroDTO);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Livro>> listar(){
        List<Livro> livros = livroService.listar();
        return ResponseEntity.ok().body(livros);
    }

    @GetMapping("/listarPorAutor")
    public ResponseEntity<?> listarPorAutor(@RequestBody LivroDTO livroDTO) {
        List<Livro> livros = livroService.listarPorAutor(livroDTO.autor());

        if(livros == null || livros.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há livros com o autor citado.");
        }
        
        return ResponseEntity.ok().body(livros);
    }


}