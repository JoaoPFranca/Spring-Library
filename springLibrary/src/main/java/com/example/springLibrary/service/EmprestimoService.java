package com.example.springLibrary.service;

import com.example.springLibrary.entity.Emprestimo;
import com.example.springLibrary.entity.Livro;
import com.example.springLibrary.entity.dto.EmprestimoDTO;
import com.example.springLibrary.repository.ClienteRepository;
import com.example.springLibrary.repository.EmprestimoRepository;
import com.example.springLibrary.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;


    public Emprestimo save(EmprestimoDTO emprestimoDTO){
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataDeEmprestimo(emprestimoDTO.dataDeEmprestimo());
        emprestimo.setResponsavel(emprestimoDTO.responsavel());

        if(emprestimoDTO.cliente() == null){
            throw new NullPointerException();
        }
        emprestimo.setCliente(emprestimoDTO.cliente());

        if(emprestimoDTO.livro() == null){
            throw new NullPointerException();
        }
        emprestimo.setLivro(emprestimoDTO.livro());

        return emprestimoRepository.save(emprestimo);
    }
}
