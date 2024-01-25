package com.example.springLibrary.repository;

import com.example.springLibrary.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
