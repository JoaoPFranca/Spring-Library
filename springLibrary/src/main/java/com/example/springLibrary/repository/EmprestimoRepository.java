package com.example.springLibrary.repository;

import com.example.springLibrary.entity.Cliente;
import com.example.springLibrary.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository  extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findAllByCliente(Cliente cliente);
}

