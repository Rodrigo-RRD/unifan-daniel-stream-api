import java.util.Arrays;
import java.util.List;

import model.Avaliacao;
import model.Item;
import model.Pedido;
import model.Prioridade;
import model.Tarefa;
import model.Transacao;
import service.AvaliacaoService;
import service.PedidoService;
import service.TarefaService;
import service.TransacaoService;

public class Atividade2 {
        public static void main(String[] args) {

                List<Item> itens1 = Arrays.asList(new Item("Geladeira", 500.0));
                List<Item> itens2 = Arrays.asList(new Item("Carro", 15000.0));
                List<Item> itens3 = Arrays.asList(new Item("Notebook", 2500.0));

                List<Pedido> pedidos = Arrays.asList(
                                new Pedido("Lucas", itens1, true),
                                new Pedido("Rodrigo", itens2, false),
                                new Pedido("Gabriel", itens3, true));

                System.out.println("----------------------------------EXERCICIO 1----------------------------------");
                PedidoService pedidoService = new PedidoService();

                pedidoService.pedidoPagos(pedidos)
                                .forEach(pedido -> System.out.println("Pedido pago: " + pedido.getCliente()));

                System.out.println("A soma dos pedidos " + pedidoService.somarItensPedido(pedidos));

                pedidoService.descontoParaPedidos(pedidos).stream()
                                .forEach(funcionario -> funcionario.getItens().stream()
                                                .forEach(item -> System.out.println(item.getValor())));

                pedidoService.pedidoAcimaDe1500(pedidos).stream().forEach(
                                funcionario -> funcionario.getItens().stream()
                                                .forEach(item -> System.out.println(
                                                                "Desconto aplicado" + item.getNome() + " Valor: "
                                                                                + item.getValor().doubleValue())));

                System.out.println("----------------------------------EXERCICIO 2----------------------------------");

                TarefaService tarefaService = new TarefaService();
                List<Tarefa> tarefas = Arrays.asList(
                                new Tarefa("Fazer atividade 1", Prioridade.ALTA, 10),
                                new Tarefa("Fazer atividade 2", Prioridade.BAIXA, 10),
                                new Tarefa("Fazer atividade 3", Prioridade.MEDIA, 10),
                                new Tarefa("Fazer atividade 4", Prioridade.PARADA, 10),
                                new Tarefa("Fazer atividade 5", Prioridade.ALTA, 10));

                tarefaService.mapearDescricao(tarefas).stream().forEach(t -> System.out.println(t));

                tarefaService.filtrarPrioridadeAlta(tarefas).stream()
                                .forEach(t -> System.out.println(t.getDescricao() + " " + t.getTempo()));

                System.out.println("Soma de todas as tarefas:" + tarefaService.calcularTempoTodasTarefas(tarefas));

                tarefaService.mapearEmOrdemPrioridade(tarefas).stream().forEach(t -> System.out
                                .println("Detalhes: " + t.getDescricao() + " Prioridade: "
                                                + t.getPrioridade().toString()));

                System.out.println("----------------------------------EXERCICIO 3----------------------------------");
                List<Avaliacao> avaliacoes = Arrays.asList(
                                new Avaliacao("João", 8.0, "TI"),
                                new Avaliacao("Maria", 9.5, "TI"),
                                new Avaliacao("Carlos", 6.5, "RH"),
                                new Avaliacao("Ana", 7.5, "TI"),
                                new Avaliacao("Paulo", 8.2, "RH"));
                String departamentoFiltro = "TI";

                AvaliacaoService avaliacaoService = new AvaliacaoService();

                avaliacaoService.avaliacoesDepartamento(avaliacoes, departamentoFiltro).stream()
                                .forEach(a -> System.out.println(
                                                "Nome:" + a.getNomeFuncionario() + " Avaliação: " + a.getNota()));

                avaliacaoService.nomesFuncionarios(avaliacoes, departamentoFiltro)
                                .forEach(a -> System.out.println("Nome: " + a.getNomeFuncionario()));
                System.out.println("Media de nota: " + avaliacaoService.mediaNotas(avaliacoes, departamentoFiltro));

                System.out.println(avaliacaoService.superiorAMediaDepartamento(avaliacoes, departamentoFiltro));

                System.out.println("----------------------------------EXERCICIO 4 ----------------------------------");

                List<Transacao> transacoes = Arrays.asList(
                                new Transacao("Pablo", "CREDITO", 800.0),
                                new Transacao("Lucas", "DEBITO", 1200.0),
                                new Transacao("Luiz", "CREDITO", 15500.0),
                                new Transacao("Michael", "CREDITO", 2000.0),
                                new Transacao("Rodrigo", "DEBITO", 100.0));

                TransacaoService transacaoService = new TransacaoService();

                transacaoService.filtrarTipoCredito(transacoes).stream().forEach(t -> System.out
                                .println("Nome cliente: " + t.getNomeCliente() + ", Tipo: " + t.getTipoTransacao()));
                System.out.println(transacaoService.mapearTransacoes(transacoes));
                System.out.println(transacaoService.cacularSomaTransacoesCredito(transacoes));
                transacaoService.mapearCreditoDebito(transacoes).stream().forEach(t -> System.out
                                .println("Nome cliente: " + t.getNomeCliente() + ", Tipo: " + t.getTipoTransacao()));
        }

}
