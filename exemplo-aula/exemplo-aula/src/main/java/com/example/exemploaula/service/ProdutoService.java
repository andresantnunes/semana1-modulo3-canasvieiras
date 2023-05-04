package com.example.exemploaula.service;

import com.example.exemploaula.controller.dto.ProdutoRequest;
import com.example.exemploaula.model.Produto;
import com.example.exemploaula.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> encontraProduto() {
        //codigo a mais
        System.out.println("Encontra Produto");
        return repository.findAll();
    }

    // nome = aa, valor = 10.0
    public Produto salvarProduto(ProdutoRequest request) {

        //resitory.save retorna Produto com o nome=nome e com valor=10.0
        return repository.save(
                new Produto(request.getNome(), request.getValor()));
    }
}
