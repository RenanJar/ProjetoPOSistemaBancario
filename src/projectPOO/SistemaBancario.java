package projectPOO;

import java.util.*;
import java.util.Scanner;

public class SistemaBancario {

	public static void main(String[] args) {

		int escolha = 0;
		int escolhaMenu = 0;
		Menu menu = new Menu();
		Conta conta = new Conta();
		ContaCorrente contaCorrente = new ContaCorrente();
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);

		conta.setNome("Betina Dias Machado");
		conta.setCPF(00);
		conta.setSenha(1234);
		contaCorrente.setSaldo(1000);

		while (escolha != 3) {
			menu.menuInicial();
			escolha = scan.nextInt();
			if (escolha == 2) {

				System.out.println(
						"-=-=-=-=--=-=-=-=-=-=-=-=-=-=-\nOlá! Seja bem-vinde à GenBanK\n-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");
				System.out.println("Por favor, digite seu nome completo: ");
				conta.setNome(scan.next() + scan.nextLine());
				System.out.println("Por favor, digite seu CPF:");
				conta.setCPF(scan.nextLong());
				System.out.println("Por favor, digite uma senha numérica: ");
				conta.setSenha(scan.nextInt());
				System.out.println("Por favor, digite seu depósito inicial: ");
				contaCorrente.setSaldo(scan.nextDouble());
				System.out.println("Cadastro efetuado com Sucesso!!!");

			}


			if (escolha == 1) {
				int sair = 0;

				while (sair != 5) {
					long cpf = 0;
					int senha = 0;
					System.out.println(
							"-=-=-=-=--=-=-=-=-=-=-=-=-=-=-\nOlá! Seja bem-vinde à GenBanK\n-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");
					try {
						System.out.println("Por favor, digite seu CPF: ");
						cpf = scan1.nextLong();
					}catch (Exception erro){
						System.out.println("Voce digitou um caracter inválido.\nPor favor, digite seu CPF: ");
						cpf = scan.nextLong();
					}


					System.out.println("Por favor, digite sua senha: ");
					senha = scan.nextInt();


					if (cpf == conta.getCPF() && senha == conta.getSenha()) {
						System.out.println("Bem-vinde " + conta.getNome() + "!\nEscolha qual conta deseja acessar:");
						menu.menuHome();
						escolhaMenu = scan.nextInt();

						if (escolhaMenu == 1) {

							ArrayList<String> extratolist = new ArrayList<>();

							while (escolhaMenu != 6) {
								menu.menuConta();
								escolhaMenu = scan.nextInt();

								if (escolhaMenu == 1) {
									escolhaMenu = 0;
									System.out.println("Saldo atual: " + contaCorrente.getSaldo());

								} else if (escolhaMenu == 2) {
									double deposito;
									System.out.println("Por favor, digite o valor a ser depositado: ");
									deposito = scan.nextDouble();
									extratolist.add("\nDepósito " + String.valueOf(deposito));
									contaCorrente.setSaldo(contaCorrente.operacao(contaCorrente.getSaldo(), deposito));
									System.out.println("Depósito efetuado com sucesso!!\nSeu saldo atual é: "
											+ contaCorrente.getSaldo());

								} else if (escolhaMenu == 3) {
									System.out.println("Por favor, digite o valor de saque: ");
									double saque = scan.nextDouble();
									if ((contaCorrente.getSaldo() - 2) >= saque) {
										extratolist.add("\nSaque -" + String.valueOf(saque));
										extratolist.add("\nTarifa -2");
										contaCorrente.setSaldo(contaCorrente.reajuste(contaCorrente.getSaldo(), 2));
										contaCorrente
												.setSaldo(contaCorrente.operacaoSaque(contaCorrente.getSaldo(), saque));
										System.out.println(
												"Saque efetuado com sucesso!!\nFoi descontada a tarifa de R$ 2,00 pelo serviço.\nSeu saldo atual é: "
														+ contaCorrente.getSaldo());
									} else {
										System.out.println("Saldo insuficiente. Efetue um depósito.");
									}
								} else if (escolhaMenu == 4) {
									System.out.println(
											"Por favor, digite o valor a ser transferido para a Conta Poupança: ");
									contaCorrente.operacao(extratolist, scan, contaCorrente, contaPoupanca, true);
									System.out.println(
											"Transferência realizada com sucesso!!\nO saldo atual da Conta Corrente é: "
													+ contaCorrente.getSaldo()
													+ " e o saldo atual da Conta Poupança é: "
													+ contaPoupanca.getSaldo());
								} else if (escolhaMenu == 5) {
									System.out.println("-=-=-=-=-=-=-=-=-=-=\nSeu Extrato Bancário\n-=-=-=-=-=-=-=-=-=-=");
									for (int x = 0; x < extratolist.size(); x++) {
										System.out.println(extratolist.get(x));
									}
									System.out.println("\n-=-=-=-=-=-=-=-=-=-=\n Saldo Atual: " + contaCorrente.getSaldo() + "\n-=-=-=-=-=-=-=-=-=-=");

								} else if (escolhaMenu > 6 || escolhaMenu == 0) {
									System.out.println("Opção inválida! Digite uma opção válida.");
								}
							}
							break;

						} else if (escolhaMenu == 2) {
							ArrayList<String> extratolist = new ArrayList<>();
							contaPoupanca.setSaldo(contaPoupanca.getSaldo()
									+ contaPoupanca.reajuste(extratolist, contaPoupanca.getSaldo(), 10));
							System.out.println(
									"Parabéns!! Você teve um rendimento de 10% sobre o saldo da sua conta poupança!"
							);
							while (escolhaMenu != 6) {
								escolhaMenu = 0;
								menu.menuConta();
								escolhaMenu = scan.nextInt();

								if (escolhaMenu == 1) {
									escolhaMenu = 0;
									System.out.println("Saldo atual: " + contaPoupanca.getSaldo());

								} else if (escolhaMenu == 2) {
									escolhaMenu = 0;
									double deposito;
									System.out.println("Por favor, digite o valor a ser depositado: ");
									deposito = scan.nextDouble();
									extratolist.add("\nDepósito " + String.valueOf(deposito));
									contaPoupanca.setSaldo(contaPoupanca.operacao(contaPoupanca.getSaldo(), deposito));
									System.out.println("Depósito efetuado com sucesso!!\nSeu saldo atual é: "
											+ contaPoupanca.getSaldo());

								} else if (escolhaMenu == 3) {
									escolhaMenu = 0;
									double saque;
									System.out.println("Por favor, digite o valor de saque: ");
									saque = scan.nextDouble();
									if (contaPoupanca.getSaldo() >= saque) {
										extratolist.add("\nSaque -" + String.valueOf(saque));
										contaPoupanca
												.setSaldo(contaPoupanca.operacaoSaque(contaPoupanca.getSaldo(), saque));
										System.out.println("Saque efetuado com sucesso!!\nSeu saldo atual é: "
												+ contaPoupanca.getSaldo());
									} else {
										System.out.println("Saldo insuficiente. Efetue um depósito.");
									}

								} else if (escolhaMenu == 4) {
									escolhaMenu = 0;
									System.out.println(
											"Por favor, digite o valor a ser transferido para a Conta Corrente: ");
									contaCorrente.operacao(extratolist, scan, contaCorrente, contaPoupanca, false);
									System.out.println(
											"Transferência realizada com sucesso!!\nO saldo atual da Conta Poupança é: "
													+ contaPoupanca.getSaldo()
													+ " e o saldo atual da Conta Corrente é: "
													+ contaCorrente.getSaldo());
								} else if (escolhaMenu == 5) {
									System.out.println("-=-=-=-=-=-=-=-=-=-=\nSeu Extrato Bancário\n-=-=-=-=-=-=-=-=-=-=");
									for (int x = 0; x < extratolist.size(); x++) {
										System.out.println(extratolist.get(x));
									}
									System.out.println("\n-=-=-=-=-=-=-=-=-=-=\n Saldo Atual: " + contaPoupanca.getSaldo() + "\n-=-=-=-=-=-=-=-=-=-=");

								} else if (escolhaMenu > 6 || escolhaMenu == 0) {
									System.out.println("Opção inválida! Digite uma opção válida.");
								}
							}
							break;

						}

					} else {
						System.out.println("CPF ou Senha inválidos.\nDigite os dados novamente.");
						break;
					}

				}
			}
		}



	}
}