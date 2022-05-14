import java.util.Scanner;

public class Conta implements Operacoes {

    private String nome;
    private long CPF;
    private int Senha;
    private double saldo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public int getSenha() {
        return Senha;
    }

    public void setSenha(int senha) {
        Senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



    @Override
    public double operacao(double A, double b) {
        double deposito=A+b;
        return deposito;
    }

    public double operacaosaque(double A, double b) {
        double saque=A-b;
        return saque;
    }

    public void operacao(Scanner scan,Contacorrente contacorrente, Contapoupança contapoupança,boolean escolha) {
        long usuario= scan.nextLong();
        if(escolha==true) {
            contacorrente.setSaldo(contacorrente.getSaldo() - usuario);
            contapoupança.setSaldo(contapoupança.getSaldo() + usuario);
        }else{
            contapoupança.setSaldo(contapoupança.getSaldo() - usuario);
            contacorrente.setSaldo(contacorrente.getSaldo() + usuario);
        }
    }

    public void operacaopoupança(Scanner scan,Contacorrente contacorrente, Contapoupança contapoupança) {
        long usuario= scan.nextLong();
        contacorrente.setSaldo(contacorrente.getSaldo()-usuario);
        contapoupança.setSaldo(contacorrente.getSaldo()+usuario);
    }




}
