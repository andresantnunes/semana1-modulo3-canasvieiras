package com.example.funcionarioaula3.controller;

import com.example.funcionarioaula3.model.Funcionario;
import com.example.funcionarioaula3.repository.FuncionarioRepository;
import com.example.funcionarioaula3.service.FuncionarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest // Carregando o Contexto do Spring Boot
@ExtendWith({SpringExtension.class, MockitoExtension.class}) // Adicionando a anotações do Spring Test e do Mockito
@AutoConfigureMockMvc // Configura o MockMvc que chama a api diretamente
class FuncionarioControllerTest {

//    @MockBean // realiza o Mock(falsificação) de uma componente dentro do Spring
//    FuncionarioService service;

    @MockBean // realiza o Mock(falsificação) de uma componente dentro do Spring
    FuncionarioRepository repository;

    @Autowired
    MockMvc mockMvc; // Age como uma chamada externa para o nosso programa

    @Test
    void retornarTodosFuncionarios() throws Exception {
        List<Funcionario> funcionarios = List.of(new Funcionario(1L,"Marco Aurelio",2000.0,2L));

//        when(service.retornaTodosFuncionarios()).thenReturn(funcionarios);

        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/funcionario")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void salvarFuncionario() throws Exception {
        Funcionario funcionarios = new Funcionario
                (1L,"Marco Aurelio",2000.0,2L);

        when(repository.save(any())).thenReturn(funcionarios);
        // gerar uma resposta mockada para o salvarFuncionario

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/funcionario")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        """
                                        {
                                        \t"nomeFuncionario":"Andre",
                                        \t"salario":1001.0,
                                        \t"tempoEmpresa":1
                                        }
                                        """)
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(
                                """
                                {
                                    "id": 1,
                                    "nomeFuncionario": "Marco Aurelio",
                                    "salario": 2000.0,
                                    "tempoEmpresa": 2
                                }
                                """
                ));
    }

    @Test
    void atualizarSalario() {
    }
}