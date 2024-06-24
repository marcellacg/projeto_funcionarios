package entities;

import java.lang.String;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Funcionario extends Pessoa {
    private double salario; //Dificuldade em prosseguir com BigDecimal
    private String funcao;

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, LocalDate data_nascimento, double salario, String funcao) {
        super(nome, data_nascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getAumento(){
        return getSalario() * 10 /100;
    }

    public double qntSalariosMinimos(){
        double salarioBase = 1212.00;
        double resultado = this.salario / salarioBase;
        double base = Math.floor(resultado);
            return base;
    }
    public int getIdade(Funcionario funcionario){
        int anoNascimento = funcionario.getData_nascimento().getYear();
        int anoAtual = LocalDate.now().getYear();
        int idade = anoAtual - anoNascimento;
        return idade;
    }

    public static void printSeparador(){
        System.out.print("\n-------------------------------------------------------------");
    }
    public static void printEnunciados(){
        String nome = "nome";
        String data = "Data de nascimento";
        String salario = "Salario";
        String funcao = "Função";
        System.out.printf("\n%s %22s %10s %10s", nome, data, salario, funcao);
    }

    public static void printInformacoes(Funcionario funcionario){
        LocalDate dataDeNascimento = funcionario.getData_nascimento();
        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataDeNascimento.format(formatadorDeData);
        System.out.printf("\n%s %15s %16.2f %9s%n", funcionario.getNome(), dataFormatada,
                funcionario.getSalario(), funcionario.getFuncao());
    }

    @Override
    public String toString() {
        return getNome() + "    " + getData_nascimento() + "             " + getSalario() + "     " + getFuncao() + "\n";
    }
}
