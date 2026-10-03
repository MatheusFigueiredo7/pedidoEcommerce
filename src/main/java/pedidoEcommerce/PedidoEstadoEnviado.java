package pedidoEcommerce;

public class PedidoEstadoEnviado extends PedidoEstado{
    private PedidoEstadoEnviado() {};
    private static pedidoEcommerce.PedidoEstadoEnviado instance = new pedidoEcommerce.PedidoEstadoEnviado();
    public static pedidoEcommerce.PedidoEstadoEnviado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Enviado";
    }

    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }
}
