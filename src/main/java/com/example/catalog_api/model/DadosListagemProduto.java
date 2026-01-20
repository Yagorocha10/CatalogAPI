package com.example.catalog_api.model;

public record DadosListagemProduto(Long id,
                                   String nome,
                                   String descricao,
                                   Double preco,
                                   Categoria categoria) {


    public DadosListagemProduto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getCategoria());
    }
}
