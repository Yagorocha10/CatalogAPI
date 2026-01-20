package com.example.catalog_api.controller;

import com.example.catalog_api.model.DadosAtualizacaoProduto;
import com.example.catalog_api.model.DadosCadastroProduto;
import com.example.catalog_api.model.DadosListagemProduto;
import com.example.catalog_api.model.Produto;
import com.example.catalog_api.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarProduto(@RequestBody @Valid DadosCadastroProduto produto) {
        repository.save(new Produto(produto));
    }

    @GetMapping
    public List<DadosListagemProduto> listarProdutos() {
        return repository.findAll().stream().map(DadosListagemProduto::new)
                .collect(Collectors.toList());
    }

    @PutMapping
    @Transactional
    public void alterarProduto(@RequestBody DadosAtualizacaoProduto dadosAtualizacaoProduto) {
            var produto = repository.getReferenceById(dadosAtualizacaoProduto.id());
            produto.atualizarInformacoes(dadosAtualizacaoProduto);
    }





}
