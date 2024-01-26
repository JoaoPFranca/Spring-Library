package com.example.springLibrary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;

    private String responsavel;
    private Date dataDeEmprestimo;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Livro livro;
}
