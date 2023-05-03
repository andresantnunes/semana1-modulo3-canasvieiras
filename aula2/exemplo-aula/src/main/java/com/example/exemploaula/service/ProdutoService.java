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
        return repository.findAll();
    }

    public Produto salvarProduto(ProdutoRequest request) {
        return repository.save(
                new Produto(request.getNome(), request.getValor()));
    }
}
