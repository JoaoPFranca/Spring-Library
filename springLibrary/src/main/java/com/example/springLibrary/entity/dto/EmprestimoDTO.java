package com.example.springLibrary.entity.dto;

import com.example.springLibrary.entity.Cliente;
import com.example.springLibrary.entity.Livro;

import java.util.Date;

public record EmprestimoDTO(String responsavel, Date dataDeEmprestimo, Long clienteId, Long livroId) {
}
