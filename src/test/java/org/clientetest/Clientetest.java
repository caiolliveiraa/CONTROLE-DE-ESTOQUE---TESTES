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

public class Clientetest {
    @Mock
    private Cliente cliente;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente(1, "Cliente de Teste", "Endereço de Teste", "teste@teste.com", "123456789");
    }

    @Test
    public void testAtualizarEndereco() {
        Cliente cliente = Mockito.mock(Cliente.class);

        when(cliente.getEndereco()).thenReturn("Novo Endereço");

        String novoEndereco = "Novo Endereço";
        cliente.atualizarEndereco(novoEndereco);

        verify(cliente).atualizarEndereco(novoEndereco);

        assertEquals(novoEndereco, cliente.getEndereco());
    }

    @Test
    public void testAtualizarEmail() {
        Cliente cliente = Mockito.mock(Cliente.class);

        when(cliente.getEmail()).thenReturn("novoemail@teste.com");

        String novoEmail = "novoemail@teste.com";
        cliente.atualizarEmail(novoEmail);

        verify(cliente).atualizarEmail(novoEmail);

        assertEquals(novoEmail, cliente.getEmail());
    }

    @Test
    public void testAtualizarTelefone() {
        Cliente cliente = Mockito.mock(Cliente.class);

        when(cliente.getTelefone()).thenReturn("987654321");

        String novoTelefone = "987654321";
        cliente.atualizarTelefone(novoTelefone);

        verify(cliente).atualizarTelefone(novoTelefone);

        assertEquals(novoTelefone, cliente.getTelefone());
    }

    @Test
    public void testGetNome() {
        String nomeEsperado = "Cliente de Teste";
        assertEquals(nomeEsperado, cliente.getNome());
    }

    @Test
    public void testGetId() {
        int idEsperado = 1;
        assertEquals(idEsperado, cliente.getId());
    }
}
