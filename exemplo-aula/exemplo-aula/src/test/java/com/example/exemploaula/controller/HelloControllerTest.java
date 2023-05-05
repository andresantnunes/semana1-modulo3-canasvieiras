package com.example.exemploaula.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Carrega o contexto do Spring para esse teste,
// anotações, injeções de dependencia, configurações application.properties
// é como se o teste executasse a aplicação por baixo dos panos
@AutoConfigureMockMvc
// configura o componente MockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc; // o MockMvc atua com um cliente do nosso projeto
    // ele nos permite acessar os endpoints do projeto como se fosse uma aplicação externa

    @Test
    void hello() throws Exception {
        mockMvc.perform( //perform realiza uma chamada em um endpoint
                        MockMvcRequestBuilders //monta uma requisão rest
                                .get("/hello") //endpoint dentro da nossa aplicação, ele chama com o método GET
                                .accept(MediaType.APPLICATION_JSON) // identificar o corpo da requisição
                )
                .andExpect(MockMvcResultMatchers.status().isOk()) // esperamos a resposta do MockMvc, queremos o status OK (200)
                .andExpect(MockMvcResultMatchers.content().string("Hello World!"));
        // queremos a string "Hello World" como conteúdo(body)
    }
}