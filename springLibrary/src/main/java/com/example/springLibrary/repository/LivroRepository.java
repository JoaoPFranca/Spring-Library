package com.example.springLibrary.repository;

import com.example.springLibrary.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository  extends JpaRepository<Livro, Long> {

    List<Livro> findAllByAutor(String autor);
}
