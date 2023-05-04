package com.example.exemploaula.service;

import com.example.exemploaula.controller.dto.ProdutoRequest;
import com.example.exemploaula.model.Produto;
import com.example.exemploaula.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService produtoService;
    // ProdutoService produtoService = new ProdutoService(repository);


    @Test
    void encontraProduto() {
        Produto produto = new Produto("nome",10.0);
        Produto produto1 = new Produto("nome",10.0);
        Produto produto2 = new Produto("nome",10.0);
        Produto produto3 = new Produto("nome",10.0);
        List<Produto> produtos = List.of(new Produto[]{produto,produto1, produto2, produto3});

        when(repository.findAll()).thenReturn(produtos);
        // toda vez que o repository.findAll()
        // for executado dentro da chamada desse método será retornada a lista com o Produto nome

        List<Produto> resultado = produtoService.encontraProduto();

        assertNotNull(resultado); // valida resultado e valor
        assertEquals("nome",resultado.get(0).getNome());

        verify(repository, times(1)).findAll(); // valida execução de código
    }

    @Test
    void salvarProduto() {
        Produto produto = new Produto("nome",10.0);

        // Funções com parametro tem que receber os genéricos: any(), anyString, anyLong(), etc
        when(repository.save(any())).thenReturn(produto);
        // exemplo de um findById
//        when(repository.findById(anyLong())).thenReturn(Optional.of(produto));

        Produto resultado = produtoService.salvarProduto(
                new ProdutoRequest("aa",10.0));

        assertNotNull(resultado);
        assertEquals("nome",resultado.getNome());

    }
}
