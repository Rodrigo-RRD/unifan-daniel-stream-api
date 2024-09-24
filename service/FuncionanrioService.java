package service;

import java.util.List;
import java.util.stream.Collectors;

import model.Funcionario;

public class FuncionanrioService {

    public List<Funcionario> funcionariosComIdadeMaiorQue30(List<Funcionario> funcionarios) {
        return funcionarios.stream().filter(funcionario -> funcionario.getIdade() > 30).collect(Collectors.toList());
    }

    public List<String> nomeDosFuncionarios(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(Funcionario::getNome).collect(Collectors.toList());
    }

    public Double somaDosSalariosFuncionarios(List<Funcionario> funcionarios) {
        return funcionarios.stream().mapToDouble(Funcionario::getSalario).sum();
    }

}
