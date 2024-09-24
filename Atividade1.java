import java.util.Arrays;
import java.util.List;

import model.Funcionario;
import service.FuncionanrioService;

public class Atividade1 {

        public static void main(String[] args) throws Exception {

                List<Funcionario> funcionarios = Arrays.asList(
                                new Funcionario("Rodrigo", 100, 2010.0),
                                new Funcionario("Lucas", 40, 2030.0),
                                new Funcionario("Gabriel", 3, 2000.0),
                                new Funcionario("michael", 5, 1000.0),
                                new Funcionario("Luis", 10, 2200.0));

                System.out.println("Nome: Rodrigo Rodrigues Ribeiro Dutra ESN5");
                FuncionanrioService funcionanrioService = new FuncionanrioService();
                funcionanrioService.funcionariosComIdadeMaiorQue30(funcionarios).stream()
                                .forEach(funcionario -> System.out
                                                .println("Nome do funcionario com idade maior que 30: "
                                                                + funcionario.getNome()));
                funcionanrioService.nomeDosFuncionarios(funcionarios).stream()
                                .forEach(funcionario -> System.out.println("Nome: " + funcionario));
                System.out.println(
                                "Soma dos salarios: " + funcionanrioService.somaDosSalariosFuncionarios(funcionarios));
        }
}
