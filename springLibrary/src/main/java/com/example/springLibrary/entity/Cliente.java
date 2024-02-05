package com.example.springLibrary.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.springLibrary.entity.Emprestimo;

import java.util.List;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;

    private String nome;
    private Integer idade;
    private String endereco;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    @JsonIgnore
    private List<Emprestimo> emprestimoList;

}
