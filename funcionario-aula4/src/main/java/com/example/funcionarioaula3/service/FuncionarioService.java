package com.example.funcionarioaula3.service;

import com.example.funcionarioaula3.controller.dto.FuncionarioRequest;
import com.example.funcionarioaula3.model.Funcionario;
import com.example.funcionarioaula3.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Double atualizarSalarioFuncionario(Long id) throws Exception {

        Funcionario funcionario = repository.findById(id).orElseThrow(Exception::new);

        long tempoEmpresa = funcionario.getTempoEmpresa()+1;
        double salarioNovo = 0.0;
        Double salarioAntigo = funcionario.getSalario();

        if (tempoEmpresa == 2L) {
            salarioNovo = 2000.0;
        } else if (tempoEmpresa == 3L || tempoEmpresa == 4L || tempoEmpresa == 5L) {
            salarioNovo = salarioAntigo * 1.25;
        } else if (tempoEmpresa > 5) {
            salarioNovo = salarioAntigo * 1.20;
        }

        funcionario.setTempoEmpresa(tempoEmpresa);
        funcionario.setSalario(salarioNovo);

        repository.save(funcionario);
        return salarioNovo;
    }

    public List<Funcionario> retornaTodosFuncionarios() {
        return repository.findAll();
    }

    public Funcionario salvarFuncionario(FuncionarioRequest funcionarioRequest) {
        return repository.save(new Funcionario(
                funcionarioRequest.getNomeFuncionario(),
                funcionarioRequest.getSalario(),
                funcionarioRequest.getTempoEmpresa()));
    }
}
