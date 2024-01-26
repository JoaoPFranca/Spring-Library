package com.example.springLibrary.repository;

import com.example.springLibrary.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository  extends JpaRepository<Emprestimo, Long> {
}

