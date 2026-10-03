package pedidoEcommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void deveNotificarUmCliente() {
        Pedido pedido = new Pedido(1001, "Notebook");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(pedido);
        pedido.pagar();
        assertEquals("Cliente 1, pedido atualizado: Pedido{numero=1001, descricaoProduto='Notebook', status='Pago'}", cliente.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarClientes() {
        Pedido pedido = new Pedido(1001, "Notebook");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(pedido);
        cliente2.acompanhar(pedido);
        pedido.pagar();
        assertEquals("Cliente 1, pedido atualizado: Pedido{numero=1001, descricaoProduto='Notebook', status='Pago'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, pedido atualizado: Pedido{numero=1001, descricaoProduto='Notebook', status='Pago'}", cliente2.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarCliente() {
        Pedido pedido = new Pedido(1001, "Notebook");
        Cliente cliente = new Cliente("Cliente 1");
        pedido.pagar();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarClientePedidoA() {
        Pedido pedidoA = new Pedido(1001, "Notebook");
        Pedido pedidoB = new Pedido(1002, "Monitor");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(pedidoA);
        cliente2.acompanhar(pedidoB);
        pedidoA.pagar();
        assertEquals("Cliente 1, pedido atualizado: Pedido{numero=1001, descricaoProduto='Notebook', status='Pago'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarQuandoTransicaoFalha() {
        Pedido pedido = new Pedido(1001, "Notebook");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(pedido);
        pedido.enviar();
        assertEquals(null, cliente.getUltimaNotificacao());
    }
}
