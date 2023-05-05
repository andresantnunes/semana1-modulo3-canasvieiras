package com.example.funcionarioaula3.controller;

import com.example.funcionarioaula3.controller.dto.FuncionarioRequest;
import com.example.funcionarioaula3.model.Funcionario;
import com.example.funcionarioaula3.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Funcionario>> retornarTodosFuncionarios(){
        List<Funcionario> funcionarios = service.retornaTodosFuncionarios();
        return new ResponseEntity<List<Funcionario>>(
                funcionarios,
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvarFuncionario(
            @RequestBody @Valid FuncionarioRequest funcionarioRequest
    ){
        Funcionario funcionario = service.salvarFuncionario(funcionarioRequest);

        return new ResponseEntity<Funcionario>(
                funcionario,
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/atualizarSalario")
    public ResponseEntity<Double> atualizarSalario(
            @RequestParam("id_funcionario") Long id ) throws Exception {
        Double novoSalario = service.atualizarSalarioFuncionario(id);

        return new ResponseEntity<Double>(
                novoSalario,
                HttpStatus.OK
        );
    }


}
