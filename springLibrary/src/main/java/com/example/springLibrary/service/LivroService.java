package com.example.springLibrary.service;

import com.example.springLibrary.entity.Livro;
import com.example.springLibrary.entity.dto.LivroDTO;
import com.example.springLibrary.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro save(LivroDTO livroDTO){
        Livro livro = new Livro();
        livro.setAutor(livroDTO.autor());
        livro.setIsbn(livroDTO.isbn());
        livro.setTitulo(livroDTO.titulo());

        return livroRepository.save(livro);
    }

    public List<Livro> listar(){
        return livroRepository.findAll();
    }

    public List<Livro> listarPorAutor(String autor){
        return  livroRepository.findAllByAutor(autor);
    }

}
