package org.produto;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private String descricao;

    public Produto(int id, String nome, double preco, int quantidade, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    // Getters e setters para os atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void removerQuantidade(int quantidadeRemovida) {
        this.quantidade -= quantidadeRemovida;
    }

    public String obterDescricao() {
        return descricao;
    }

    public void adicionarQuantidade(int quantidadeAdicional) {
        this.quantidade += quantidadeAdicional;
    }

    public void atualizarPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public double calcularValorTotal() {
        return preco * quantidade;
    }

}
