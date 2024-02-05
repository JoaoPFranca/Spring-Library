package com.example.springLibrary.controller;

import com.example.springLibrary.entity.Cliente;
import com.example.springLibrary.entity.Emprestimo;
import com.example.springLibrary.entity.dto.EmprestimoDTO;
import com.example.springLibrary.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    @Autowired
    EmprestimoService emprestimoService;


    @PostMapping("/save")
    public ResponseEntity<Emprestimo> saveEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO){
        Emprestimo emprestimo = emprestimoService.save(emprestimoDTO);
        return ResponseEntity.ok().body(emprestimo);
    }
}
