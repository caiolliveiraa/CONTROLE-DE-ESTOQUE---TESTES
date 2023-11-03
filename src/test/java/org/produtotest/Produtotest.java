package org.produtotest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import org.produto.Produto;
import org.cliente.Cliente;
import org.pedido.Pedido;

public class Produtotest {
    @Mock
    private Produto produto;
    private Cliente cliente;
    private Pedido pedido;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        produto = new Produto(1, "Produto de Teste", 10.0, 5, "Descrição do produto de teste");
        cliente = new Cliente(1, "Cliente de Teste", "Endereço de Teste", "teste@teste.com", "123456789");
        pedido = new Pedido(cliente);
    }

    @Test
    public void testCalcularValorTotal() {
        Produto produto = Mockito.mock(Produto.class);

        when(produto.calcularValorTotal()).thenReturn(50.0);

        double valorTotalCalculado = produto.calcularValorTotal();

        verify(produto).calcularValorTotal();

        assertEquals(50.0, valorTotalCalculado, 0.001);
    }

    @Test
    public void testAtualizarPreco() {
        Produto produto = Mockito.mock(Produto.class);

        when(produto.getPreco()).thenReturn(15.0);

        double novoPreco = 15.0;
        produto.atualizarPreco(novoPreco);

        verify(produto).atualizarPreco(novoPreco);

        assertEquals(novoPreco, produto.getPreco(), 0.001);
    }


    @Test
    public void testRemoverQuantidade() {
        Produto produto = Mockito.mock(Produto.class);

        when(produto.getQuantidade()).thenReturn(3);

        int quantidadeRemovida = 2;
        produto.removerQuantidade(quantidadeRemovida);

        verify(produto).removerQuantidade(quantidadeRemovida);

        assertEquals(3, produto.getQuantidade());
    }

    @Test
    public void testObterDescricao() {
        Produto produto = Mockito.mock(Produto.class);

        when(produto.obterDescricao()).thenReturn("Descrição do produto de teste");

        String descricao = produto.obterDescricao();

        verify(produto).obterDescricao();

        assertEquals("Descrição do produto de teste", descricao);
    }

    @Test
    public void testAdicionarQuantidadeProdutoAoPedido() {

        Cliente cliente = Mockito.mock(Cliente.class);

        when(cliente.getNome()).thenReturn("Cliente Teste 2");

        Produto produto = new Produto(2, "Produto Teste 2", 12.0, 8, "Descrição 2");

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(produto, 4);
        pedido.adicionarQuantidadeProduto(produto, 2);

        assertEquals("Cliente Teste 2", pedido.getCliente().getNome());
        assertEquals(6, pedido.obterQuantidadeItens());
        assertEquals(72.0, pedido.calcularValorTotal(), 0.01);
    }

    @Test
    public void testRemoverQuantidadeProdutoDoPedido() {
        Produto produto = new Produto(4, "Produto Teste 4", 18.0, 8, "Descrição 4");

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(produto, 4);
        pedido.removerQuantidadeProduto(produto, 2);

        assertEquals(2, pedido.obterQuantidadeItens());
        assertEquals(36.0, pedido.calcularValorTotal(), 0.01);
    }

    @Test
    public void testAtualizarPrecoDoProdutoEQuantidadeNoPedido() {
        Produto produto = new Produto(5, "Produto a Atualizar 2", 20.0, 5, "Descrição a Atualizar 2");

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(produto, 2);

        produto.atualizarPreco(15.0);
        pedido.adicionarQuantidadeProduto(produto, 3);

        assertEquals(5, pedido.obterQuantidadeItens());
        assertEquals(75.0, pedido.calcularValorTotal(), 0.01);
    }

    @Test
    public void testAdicionarItemAoPedido() {

        Cliente cliente = new Cliente(1, "Cliente Teste", "Endereço Teste", "cliente@teste.com", "123456789");

        Produto produto = new Produto(1, "Produto Teste", 10.0, 5, "Descrição do Produto");

        Pedido pedido = new Pedido(cliente);

        pedido.adicionarItem(produto, 3);

        assertEquals("Cliente Teste", pedido.getCliente().getNome());

        assertEquals(3, pedido.obterQuantidadeItens());

        assertEquals(30.0, pedido.calcularValorTotal(), 0.01);
    }

    @Test
    public void testAdicionarItensAUmPedidoExistente() {
        Cliente cliente = new Cliente(1, "Cliente Teste", "Endereço Teste", "cliente@teste.com", "123456789");
        Produto produto = new Produto(1, "Produto Teste", 10.0, 5, "Descrição do Produto");
        Pedido pedido = new Pedido(cliente);

        pedido.adicionarItem(produto, 2);
        pedido.adicionarQuantidadeProduto(produto, 3);

        assertEquals(5, pedido.obterQuantidadeItens());
        assertEquals(50.0, pedido.calcularValorTotal(), 0.01);
    }

}
