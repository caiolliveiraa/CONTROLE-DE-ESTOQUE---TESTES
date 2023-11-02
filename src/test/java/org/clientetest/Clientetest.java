package org.clientetest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import org.cliente.Cliente;
import org.produto.Produto;

public class Clientetest {
    private Cliente cliente;

    @Before
    public void setUp() {
        cliente = new Cliente(1, "Cliente de Teste", "Endereço de Teste", "teste@teste.com", "123456789");
    }

    @Test
    public void testClienteProdutoIntegration() {
        Produto produto = new Produto(1, "Produto de Teste", 10.0, 5, "Descrição do produto de teste");
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(produto, 3);

        assertEquals(3, pedido.obterQuantidadeItens());
        assertEquals(30.0, pedido.calcularValorTotal(), 0.001);
    }

    @Test
    public void testClienteAtualizarEndereco() {
        String novoEndereco = "Novo Endereço";
        cliente.atualizarEndereco(novoEndereco);
        assertEquals(novoEndereco, cliente.getEndereco());
    }

    @Test
    public void testClienteAtualizarEmail() {
        String novoEmail = "novoemail@teste.com";
        cliente.atualizarEmail(novoEmail);
        assertEquals(novoEmail, cliente.getEmail());
    }

    @Test
    public void testClienteAtualizarTelefone() {
        String novoTelefone = "987654321";
        cliente.atualizarTelefone(novoTelefone);
        assertEquals(novoTelefone, cliente.getTelefone());
    }

    @Test
    public void testClienteAdicionarProdutoPedidoIntegration() {
        Produto produto = new Produto(1, "Produto de Teste", 10.0, 5, "Descrição do produto de teste");
        Pedido pedido = new Pedido(cliente);

        pedido.adicionarItem(produto, 2);

        assertEquals(2, pedido.obterQuantidadeItens());
        assertEquals(20.0, pedido.calcularValorTotal(), 0.001);
    }
}

