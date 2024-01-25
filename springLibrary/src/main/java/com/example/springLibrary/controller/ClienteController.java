package com.example.springLibrary.controller;

import com.example.springLibrary.entity.Cliente;
import com.example.springLibrary.entity.dto.ClienteDTO;
import com.example.springLibrary.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<Cliente> saveCliente(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteService.save(clienteDTO);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> clientes = clienteService.listar();
        return ResponseEntity.ok().body(clientes);
    }
}
