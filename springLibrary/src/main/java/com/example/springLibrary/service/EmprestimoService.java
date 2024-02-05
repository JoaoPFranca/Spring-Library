package com.example.springLibrary.service;

import com.example.springLibrary.entity.Cliente;
import com.example.springLibrary.entity.Emprestimo;
import com.example.springLibrary.entity.Livro;
import com.example.springLibrary.entity.dto.EmprestimoDTO;
import com.example.springLibrary.repository.ClienteRepository;
import com.example.springLibrary.repository.EmprestimoRepository;
import com.example.springLibrary.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private ClienteRepository clienteRepository;


    public Emprestimo save(EmprestimoDTO emprestimoDTO){
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataDeEmprestimo(emprestimoDTO.dataDeEmprestimo());
        emprestimo.setResponsavel(emprestimoDTO.responsavel());

        if(emprestimoDTO.clienteId() == null){
            throw new NullPointerException();
        }

        Optional<Cliente> optionalCliente = clienteRepository.findById(emprestimoDTO.clienteId());

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            emprestimo.setCliente(cliente);
        }

        Optional<Livro> optionalLivro = livroRepository.findById(emprestimoDTO.livroId());

        if (optionalLivro.isPresent()) {
            Livro livro = optionalLivro.get();
            emprestimo.setLivro(livro);
        }

        return emprestimoRepository.save(emprestimo);
    }
}
