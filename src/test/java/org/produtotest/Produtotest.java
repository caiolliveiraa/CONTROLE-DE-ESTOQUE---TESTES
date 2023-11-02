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

public class Produtotest {
    @Mock
    private Produto produto;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        produto = new Produto(1, "Produto de Teste", 10.0, 5, "Descrição do produto de teste");
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
    public void testAdicionarQuantidade() {
        Produto produto = Mockito.mock(Produto.class);

        when(produto.getQuantidade()).thenReturn(5);

        int quantidadeInicial = produto.getQuantidade();
        int quantidadeAdicional = 3;

        produto.adicionarQuantidade(quantidadeAdicional);

        verify(produto).adicionarQuantidade(quantidadeAdicional);

        assertEquals(quantidadeInicial + quantidadeAdicional, produto.getQuantidade());
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
}
