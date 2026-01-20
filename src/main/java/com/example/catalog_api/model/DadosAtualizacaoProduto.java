package com.example.catalog_api.model;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
        @NotNull
        Long id,
        String nome,
        Double preco,
        String descricao,
        Categoria categoria
) {
}
