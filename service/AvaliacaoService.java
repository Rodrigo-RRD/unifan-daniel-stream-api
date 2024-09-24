package service;

import java.util.List;
import java.util.stream.Collectors;

import model.Avaliacao;

public class AvaliacaoService {

    public List<Avaliacao> avaliacoesDepartamento(List<Avaliacao> avaliacoes, String departamentoFiltro) {
        return avaliacoes.stream()
                .filter(a -> a.getDepartamento().equals(departamentoFiltro))
                .collect(Collectors.toList());
    }

    public List<Avaliacao> nomesFuncionarios(List<Avaliacao> avaliacoes, String departamentoFiltro) {
        return avaliacoesDepartamento(avaliacoes, departamentoFiltro).stream()
                .filter(a -> a.getDepartamento().equals(departamentoFiltro))
                .collect(Collectors.toList());
    }

    public double mediaNotas(List<Avaliacao> avaliacoes, String departamentoFiltro) {
        return avaliacoesDepartamento(avaliacoes, departamentoFiltro).stream()
                .mapToDouble(Avaliacao::getNota)
                .average()
                .orElse(0.0);
    }

    public List<Avaliacao> superiorAMediaDepartamento(List<Avaliacao> avaliacoes, String departamentoFiltro) {
        avaliacoesDepartamento(avaliacoes, departamentoFiltro).stream()
                .filter(a -> a.getNota() > mediaNotas(avaliacoes, departamentoFiltro))
                .forEach(a -> System.out.println(a.getNomeFuncionario()));
        return avaliacoes;
    }

}
