package org.pedidotest;

import org.junit.Before;
import org.junit.Test;
import org.cliente.Cliente;
import org.produto.Produto;
import org.pedido.Pedido;

import static org.junit.Assert.assertEquals;

public class Pedidotest {
    private Pedido pedido;
    private Cliente cliente;
    private Produto produto;

    @Before
    public void setUp() {
        cliente = new Cliente(1, "Cliente de Teste", "Endereço de Teste", "teste@teste.com", "123456789");
        produto = new Produto(1, "Produto de Teste", 10.0, 5, "Descrição do produto de teste");
        pedido = new Pedido(cliente);
    }

    @Test
    public void testPedidoClienteIntegration() {
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(produto, 3);

        assertEquals(3, pedido.obterQuantidadeItens());
        assertEquals(30.0, pedido.calcularValorTotal(), 0.001);
    }

    @Test
    public void testPedidoAdicionarProdutoClienteIntegration() {
        pedido.adicionarItem(produto, 2);

        assertEquals(2, pedido.obterQuantidadeItens());
        assertEquals(20.0, pedido.calcularValorTotal(), 0.001);
    }

    @Test
    public void testPedidoAtualizarCliente() {
        Cliente novoCliente = new Cliente(2, "Novo Cliente", "Novo Endereço", "novo@teste.com", "987654321");
        pedido.atualizarCliente(novoCliente);

        assertEquals(novoCliente, pedido.getCliente());
    }

    @Test
    public void testPedidoAdicionarQuantidadeProduto() {
        pedido.adicionarItem(produto, 2);
        pedido.adicionarQuantidadeProduto(produto, 3);

        assertEquals(5, pedido.obterQuantidadeItens());
    }

    @Test
    public void testPedidoRemoverQuantidadeProduto() {
        pedido.adicionarItem(produto, 5);
        pedido.removerQuantidadeProduto(produto, 2);

        assertEquals(3, pedido.obterQuantidadeItens());
    }
}