package pedidoEcommerce;

public class PedidoEstadoEntregue extends PedidoEstado{
    private PedidoEstadoEntregue() {};
    private static pedidoEcommerce.PedidoEstadoEntregue instance = new pedidoEcommerce.PedidoEstadoEntregue();
    public static pedidoEcommerce.PedidoEstadoEntregue getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Entregue";
    }
}
