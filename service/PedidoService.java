package service;

import java.util.List;
import java.util.stream.Collectors;

import model.Item;
import model.Pedido;

public class PedidoService {

    public List<Pedido> pedidoPagos(List<Pedido> pedidos) {
        return pedidos.stream().filter(pedido -> pedido.getPago() == true).collect(Collectors.toList());
    }

    public Double somarItensPedido(List<Pedido> pedidos) {
        return pedidos.stream()
                .flatMap(pedido -> pedido.getItens().stream()) // Transformar os pedidos em fluxos de itens
                .mapToDouble(Item::getValor)
                .sum();
    }

    // aplicar desconto de 10% para todos os pedidos acima de 1000R
    public List<Pedido> descontoParaPedidos(List<Pedido> pedidos) {
        pedidos
                .forEach(pedido -> pedido.getItens().stream().filter(item -> item.getValor() > 1000).forEach(item -> {
                    Double valorComDesconto = item.getValor() * 0.9;
                    item.setValor(valorComDesconto);
                }));
        return pedidos;
    }

    public List<Pedido> pedidoAcimaDe1500(List<Pedido> pedidos) {
        descontoParaPedidos(pedidos)
                .forEach(pedido -> pedido.getItens().stream().filter(item -> item.getValor() > 1500));
        return pedidos;
    }
}
