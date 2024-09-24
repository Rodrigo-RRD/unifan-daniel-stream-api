package service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.Transacao;

public class TransacaoService {

    public List<Transacao> filtrarTipoCredito(List<Transacao> transacoes) {
        return transacoes.stream().filter(t -> t.getTipoTransacao() == "CREDITO").collect(Collectors.toList());
    }

    public List<Double> mapearTransacoes(List<Transacao> transacoes) {
        return transacoes.stream().map(t -> t.getValor()).collect(Collectors.toList());
    }

    public double cacularSomaTransacoesCredito(List<Transacao> transacoes) {
        return transacoes.stream().mapToDouble(Transacao::getValor).sum();
    }

    public List<Transacao> mapearCreditoDebito(List<Transacao> transacoes) {
        transacoes.sort(Comparator.comparing(Transacao::getTipoTransacao));
        return transacoes;
    }
}
