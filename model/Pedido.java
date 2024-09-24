package model;

import java.util.List;

public class Pedido {
    private String cliente;
    private List<Item> itens;
    private Boolean pago = Boolean.FALSE;

    public Pedido(String cliente, List<Item> itens, Boolean pago) {
        this.cliente = cliente;
        this.itens = itens;
        this.pago = pago;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

}
