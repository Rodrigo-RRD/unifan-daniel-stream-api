package model;

public class Tarefa {

    String descricao;

    Prioridade prioridade;

    Integer tempo;

    public Tarefa(String descricao, Prioridade prioridade, Integer tempo) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.tempo = tempo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

}
