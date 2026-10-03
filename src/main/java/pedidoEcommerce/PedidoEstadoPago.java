package pedidoEcommerce;

public class PedidoEstadoPago extends PedidoEstado{
    private PedidoEstadoPago() {};
    private static pedidoEcommerce.PedidoEstadoPago instance = new pedidoEcommerce.PedidoEstadoPago();
    public static pedidoEcommerce.PedidoEstadoPago getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pago";
    }

    public boolean enviar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
