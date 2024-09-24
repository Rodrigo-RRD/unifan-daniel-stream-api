package model;

public class Transacao {
    String nomeCliente;
    String tipoTransacao;
    Double valor;

    public Transacao(String nomeCliente, String tipoTransacao, Double valor) {
        this.nomeCliente = nomeCliente;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
