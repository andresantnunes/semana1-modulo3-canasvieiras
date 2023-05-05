package com.example.funcionarioaula3.service;

import com.example.funcionarioaula3.model.Funcionario;
import com.example.funcionarioaula3.repository.FuncionarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // adiciona as anotações do Mockito no teste
class FuncionarioServiceTest {
//Teste Unitário

    @Mock // gerar os fakes do repository
    private FuncionarioRepository repository;

    @InjectMocks // insere os Mocks dentro da Classe FuncionarioService
    private FuncionarioService service;

    @Test
    void atualizarSalarioFuncionario() throws Exception {

        //Given - BDD
        //Definiu os dados do Mock
        Funcionario funcionario =
                new Funcionario(1L,"André Machado",1000.0,1L);

        //Mock do findById e do Save no FuncionarioRespository
        when(repository.findById(anyLong())).thenReturn(Optional.of(funcionario));

        //When - BDD
        //Chamada do método a ser testado
        Double salarioResultado = service.atualizarSalarioFuncionario(1L);

        //Then - BDD
        //A validação do Resultado da chamada do método
        Assertions.assertEquals(2000.0, salarioResultado);

    }

    @Test
    void atualizarSalarioFuncionario2() throws Exception {

        //Given - BDD
        //Definiu os dados do Mock
        Funcionario funcionario =
                new Funcionario(1L,"André Machado",2000.0,2L);

        //Mock do findById e do Save no FuncionarioRespository
        when(repository.findById(anyLong())).thenReturn(Optional.of(funcionario));

        //When - BDD
        //Chamada do método a ser testado
        Double salarioResultado = service.atualizarSalarioFuncionario(2L);

        //Then - BDD
        //A validação do Resultado da chamada do método
        Assertions.assertEquals(2000.0*1.25, salarioResultado);

    }

    @Test
    void atualizarSalarioFuncionario3() throws Exception {

        //Given - BDD
        //Definiu os dados do Mock
        Funcionario funcionario =
                new Funcionario(1L,"André Machado",3000.0,6L);

        //Mock do findById e do Save no FuncionarioRespository
        when(repository.findById(anyLong())).thenReturn(Optional.of(funcionario));

        //When - BDD
        //Chamada do método a ser testado
        Double salarioResultado = service.atualizarSalarioFuncionario(1L);

        //Then - BDD
        //A validação do Resultado da chamada do método
        Assertions.assertEquals(3000.0*1.20, salarioResultado);

    }
}