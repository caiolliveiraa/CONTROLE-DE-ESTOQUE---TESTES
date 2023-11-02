package org.pedido;

import org.cliente.Cliente;
import org.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Produto> produtos;
    private List<Integer> quantidades;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.quantidades = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void atualizarCliente(Cliente novoCliente) {
        this.cliente = novoCliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        produtos.add(produto);
        quantidades.add(quantidade);
    }

    public int obterQuantidadeItens() {
        int totalQuantidade = 0;
        for (int quantidade : quantidades) {
            totalQuantidade += quantidade;
        }
        return totalQuantidade;
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            valorTotal += produto.getPreco() * quantidade;
        }
        return valorTotal;
    }

    public void adicionarQuantidadeProduto(Produto produto, int quantidade) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).equals(produto)) {
                quantidades.set(i, quantidades.get(i) + quantidade);
                return;
            }
        }
        produtos.add(produto);
        quantidades.add(quantidade);
    }

    public void removerQuantidadeProduto(Produto produto, int quantidade) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).equals(produto)) {
                quantidades.set(i, quantidades.get(i) - quantidade);
                if (quantidades.get(i) <= 0) {
                    produtos.remove(i);
                    quantidades.remove(i);
                }
                return;
            }
        }
    }
}