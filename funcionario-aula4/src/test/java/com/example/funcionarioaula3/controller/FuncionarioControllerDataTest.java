package com.example.funcionarioaula3.controller;

import com.example.funcionarioaula3.model.Funcionario;
import com.example.funcionarioaula3.repository.FuncionarioRepository;
import com.example.funcionarioaula3.service.FuncionarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class) // Adicionando a anotações do Spring Test e do Mockito
@DataJpaTest // cria um respositorio fake para testarmos a nossa classe Repository
class FuncionarioControllerDataTest {
    @Autowired
    FuncionarioRepository repository; // eu apenas consigo trazer o repository para o teste

    // Teste de Componente ou de Integração
    @Test
    void retornarTodosFuncionarios() throws Exception {
        repository.save(new Funcionario(1L,"Marco Aurelio",2000.0,2L));

        List<Funcionario> funcionarios = repository.findAll(); // validando se o repository está funcionando corretamente

        Assertions.assertEquals("Marco Aurelio", funcionarios.get(0).getNomeFuncionario());
    }
}