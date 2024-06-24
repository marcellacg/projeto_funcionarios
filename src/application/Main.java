package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import entities.Funcionario;

import static entities.Funcionario.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Funcionario> listaFuncionarios = new ArrayList<>();



        String respostaFinal = "S";
        while (!respostaFinal.equalsIgnoreCase("N")){
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.print("Nome: ");
            String nome = sc.next();
            if (nome.isEmpty()){
                break;
            }

            System.out.print("Data de nascimento: ");
            String data = sc.next();

            LocalDate dataDeNascimento = LocalDate.parse(data, formatador);

            System.out.print("Salário: ");
            double salario = sc.nextDouble();

            System.out.print("Funcão: ");
            String funcao = sc.next();

            listaFuncionarios.add(new Funcionario(nome, dataDeNascimento, salario, funcao));

            System.out.println("Adicionar outro funcionário? [S/N]: ");
            respostaFinal = sc.next();

        }



        System.out.println("Nome     Data de Nascimento     Salário     Função");
        for (Funcionario funcionario : listaFuncionarios) {
            printInformacoes(funcionario);
        }
        printSeparador();
        System.out.print("\nDeseja remover um funcionário? [S/N]: ");

        String resposta = sc.next();
        if (resposta.equalsIgnoreCase("n")) {
            System.out.println(" ");

        } else if (resposta.equalsIgnoreCase("s")) {

            System.out.print("Digite o nome: ");
            String nomeRemover = sc.next();


            for (int i = 0; i < listaFuncionarios.size(); i++) {

                Funcionario funcionario = listaFuncionarios.get(i);
                if (funcionario.getNome().equals(nomeRemover)) {
                    listaFuncionarios.remove(i);
                }
            }
        }
        printEnunciados();

        for (Funcionario funcionario : listaFuncionarios) {
            printInformacoes(funcionario);
        }
        printSeparador();

        System.out.println(" ");

        System.out.println("Funcionários receberam 10% de aumento. Novos valores:");
        printEnunciados();
        for (Funcionario funcionario : listaFuncionarios) {
            funcionario.setSalario(funcionario.getSalario() + funcionario.getAumento());
            printInformacoes(funcionario);
        }

        printSeparador();
        System.out.print("\nFuncionários por grupo de função: ");

        Map<String, List<Funcionario>> funcionariosPorFuncao = listaFuncionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        funcionariosPorFuncao.forEach((funcao, lista_de_funcionarios) -> {
            System.out.print("\nFunção do funcionário: " + funcao);
            lista_de_funcionarios.forEach(funcionario -> System.out.println("\n" + funcionario
                    .getNome()));
        });

        printSeparador();
        System.out.println("\nFuncionário com mês de aniversário 10 ou 12: ");

        System.out.print("\nNome: ");

        for (Funcionario funcionario : listaFuncionarios) {
            int mesAniversario = funcionario.getData_nascimento().getMonthValue();
            if (mesAniversario == 10 || mesAniversario == 12) {
                System.out.print("\n" + funcionario.getNome());
                }
            }

            printSeparador();
            System.out.print("\nFuncionário(s) mais velho(s): ");

            System.out.print("\nNome    Idade");

            //Dificuldade em pegar a idade mais antiga
            for (Funcionario funcionarioAno : listaFuncionarios) {
                System.out.print("\n" + funcionarioAno.getNome() + "    " +
                        funcionarioAno.getIdade(funcionarioAno));
            }


            printSeparador();
            System.out.print("\nFuncionários por ordem alfabética");

            printEnunciados();

            listaFuncionarios.sort(Comparator.comparing(Funcionario::getNome));
            for (Funcionario funcionarioOrdemAlfabetica : listaFuncionarios) {
                printInformacoes(funcionarioOrdemAlfabetica);
            }

            printSeparador();
            System.out.print("\nTotal salários: ");

            double salarios = 0;
            for (Funcionario funcionarioSalario : listaFuncionarios) {
                salarios += funcionarioSalario.getSalario();
            }

            System.out.printf("R$: %.2f", salarios);

            printSeparador();
            System.out.print("\nQuantidade de salários mínimos que cada funcionário ganha:");

            for (Funcionario funcionarioQntSalario : listaFuncionarios) {
                double salarioFuncionario = funcionarioQntSalario.getSalario();

                if (salarioFuncionario < 1212.00){
                    System.out.print("\n" + funcionarioQntSalario.getNome() +
                            " ganha menos de um salário minimo.");
                } else {
                    System.out.printf("\n%s ganha pelo menos %.0f salário(s) mínimo(s)",
                            funcionarioQntSalario.getNome(),
                            funcionarioQntSalario.qntSalariosMinimos());
                }

            }
    }
}
