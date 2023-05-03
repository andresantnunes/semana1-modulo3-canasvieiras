package com.example.exemploaula.controller;

import com.example.exemploaula.controller.dto.ProdutoRequest;
import com.example.exemploaula.model.Produto;
import com.example.exemploaula.repository.ProdutoRepository;
import com.example.exemploaula.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProduto(){
        return new ResponseEntity<List<Produto>>(
                produtoService.encontraProduto(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Produto> postProduto(
            @RequestBody ProdutoRequest request){
        return new ResponseEntity<Produto>(
                produtoService.salvarProduto(request),
                HttpStatus.CREATED
        );
    }
}
