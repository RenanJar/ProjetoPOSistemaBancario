package projectPOO;

import java.util.ArrayList;
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

	//sobreposição-sobrescrita
	@Override
	public double operacao(double A, double b) {
		double deposito = A + b;
		return deposito;
	}

	public double operacaoSaque(double A, double b) {
		double saque = A - b;
		return saque;
	}

	///sobrecarga
	public void operacao(ArrayList<String> array, Scanner scan, ContaCorrente contaCorrente, ContaPoupanca contaPoupanca, boolean escolha) {
		double usuario = scan.nextDouble();
		array.add("\nTransferência -"+String.valueOf(usuario));
		if (escolha == true) {
			contaCorrente.setSaldo(contaCorrente.getSaldo() - usuario);
			contaPoupanca.setSaldo(contaPoupanca.getSaldo() + usuario);
		} else {
			contaPoupanca.setSaldo(contaPoupanca.getSaldo() - usuario);
			contaCorrente.setSaldo(contaCorrente.getSaldo() + usuario);
		}

	}

}
