package service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.Prioridade;
import model.Tarefa;

public class TarefaService {

    public List<Tarefa> filtrarPrioridadeAlta(List<Tarefa> tarefas) {
        return tarefas.stream().filter(tarefa -> tarefa.getPrioridade() == Prioridade.ALTA)
                .collect(Collectors.toList());
    }

    public List<String> mapearDescricao(List<Tarefa> tarefas) {
        return tarefas.stream().map(Tarefa::getDescricao).collect(Collectors.toList());
    }

    public int calcularTempoTodasTarefas(List<Tarefa> tarefas) {
        return tarefas.stream().mapToInt(Tarefa::getTempo).sum();
    }

    public List<Tarefa> mapearEmOrdemPrioridade(List<Tarefa> tarefas) {
        tarefas.sort(Comparator.comparing(Tarefa::getPrioridade));
        return tarefas;
    }
}
