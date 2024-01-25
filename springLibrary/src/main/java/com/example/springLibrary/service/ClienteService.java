package com.example.springLibrary.service;

import com.example.springLibrary.entity.Cliente;
import com.example.springLibrary.entity.dto.ClienteDTO;
import com.example.springLibrary.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired //Injeção da variável
    private ClienteRepository clienteRepository;
    public Cliente save(ClienteDTO clienteDTO){ //DTO faz uma ponte entre o serviço e a entidade
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.nome());
        cliente.setEmail(clienteDTO.email());
        cliente.setEndereco(clienteDTO.endereco());
        cliente.setIdade(clienteDTO.idade());
        cliente.setTelefone(clienteDTO.telefone());

        if(clienteDTO.nome() == null){
            throw new NullPointerException();
        }

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

}
