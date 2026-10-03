package pedidoEcommerce;

import java.util.Observable;

public class Pedido extends Observable {

    private Integer numero;
    private String descricaoProduto;
    private PedidoEstado estado;

    public Pedido(Integer numero, String descricaoProduto) {
        this.numero = numero;
        this.descricaoProduto = descricaoProduto;
        this.estado = PedidoEstadoCriado.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public boolean pagar() {
        boolean sucesso = estado.pagar(this);
        if (sucesso) {
            setChanged();
            notifyObservers();
        }
        return sucesso;
    }

    public boolean enviar() {
        boolean sucesso = estado.enviar(this);
        if (sucesso) {
            setChanged();
            notifyObservers();
        }
        return sucesso;
    }

    public boolean entregar() {
        boolean sucesso = estado.entregar(this);
        if (sucesso) {
            setChanged();
            notifyObservers();
        }
        return sucesso;
    }

    public boolean cancelar() {
        boolean sucesso = estado.cancelar(this);
        if (sucesso) {
            setChanged();
            notifyObservers();
        }
        return sucesso;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", descricaoProduto='" + descricaoProduto + '\'' +
                ", status='" + getNomeEstado() + '\'' +
                '}';
    }
}
