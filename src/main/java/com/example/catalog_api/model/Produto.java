package com.example.catalog_api.model;
import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Produto() {
    }


    public Produto(DadosCadastroProduto dadosCadastroProduto) {
        this.nome = dadosCadastroProduto.nome();
        this.descricao = dadosCadastroProduto.descricao();
        this.preco = dadosCadastroProduto.preco();
        this.categoria = dadosCadastroProduto.categoria();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void atualizarInformacoes(DadosAtualizacaoProduto dadosAtualizacaoProduto) {
        if (dadosAtualizacaoProduto.nome() != null) {
            this.nome = dadosAtualizacaoProduto.nome();
        }

        if (dadosAtualizacaoProduto.descricao() != null) {
            this.descricao = dadosAtualizacaoProduto.descricao();
        }

        if (dadosAtualizacaoProduto.preco() != null) {
            this.preco = dadosAtualizacaoProduto.preco();
        }

        if (dadosAtualizacaoProduto.categoria() != null) {
            this.categoria = dadosAtualizacaoProduto.categoria();
        }
    }
}
