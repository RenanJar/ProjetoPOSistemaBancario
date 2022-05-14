import java.sql.SQLOutput;
import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {

        int escolha= 0;
        int escolhamenu= 0;
        Menu menu= new Menu();
        Conta conta=new Conta();
        Contacorrente contacorrente = new Contacorrente();
        Contapoupança contapoupança = new Contapoupança();
        Scanner scan = new Scanner(System.in);

        while(escolha!=3){
            ///ponto a melhorar limitar as escolha
            menu.menuinicial();
            escolha=scan.nextInt();
            if(escolha==2){
                System.out.println("Olá! Seja bem vinde à GenBanK");
                System.out.println("Por favor digite seu nome");
                conta.setNome(scan.next() + scan.nextLine());
                ///exception???
                System.out.println("Por favor digite seu CPF");
                conta.setCPF(scan.nextLong());
                System.out.println("Por favor digite sua Senha");
                conta.setSenha(scan.nextInt());
                System.out.println("Por favor digite seu deposito inicial");
                contacorrente.setSaldo(scan.nextInt());
                System.out.println("Cadastro efetuado com Sucesso!!!");
            }

            if(escolha==1){
                int sair=0;
                while(sair!=5) {

                    System.out.println("Olá! Seja bem vinde à GenBanK");
                    System.out.println("Por favor digite o CPF");
                    long cpf;
                    cpf = scan.nextLong();
                    System.out.println("Por favor digite sua senha: ");
                    int senha;
                    senha = scan.nextInt();

                    if(cpf == conta.getCPF() && senha == conta.getSenha()) {
                        System.out.println("Bem vinde "+conta.getNome());
                        menu.menuhome();///conta correte ou poupança
                        escolhamenu=scan.nextInt();


                        if(escolhamenu==1) {
                            while(escolhamenu!=5) {
                                escolhamenu = 0;
                                menu.menuconta();
                                escolhamenu = scan.nextInt();

                                if (escolhamenu == 1) {
                                    escolhamenu = 0;
                                    System.out.println("Saldo atual: " + contacorrente.getSaldo());

                                } else if (escolhamenu == 2) {
                                    escolhamenu = 0;
                                    double deposito;
                                    System.out.println("Por favor digite o valor a ser depositado: ");
                                    deposito= scan.nextInt();
                                    contacorrente.setSaldo(contacorrente.operacao(contacorrente.getSaldo(),deposito));

                                } else if (escolhamenu == 3) {
                                    escolhamenu = 0;
                                    System.out.println("Por favor digite o valor de saque: ");
                                    double saque= scan.nextInt();
                                    if((contacorrente.getSaldo()-2)>=saque){
                                        contacorrente.setSaldo(contacorrente.reajuste(contacorrente.getSaldo(),2));
                                        contacorrente.setSaldo(contacorrente.operacaosaque(contacorrente.getSaldo(),saque));
                                        System.out.println("Saque efetuado com sucesso\nfoi descontado a tarifa de R$ 2 seu saldo atual é: "+contacorrente.getSaldo());
                                    }else{
                                        System.out.println("Saldo invalido efetue um depoisto");
                                    }
                                } else if (escolhamenu == 4) {
                                    escolhamenu = 0;
                                    System.out.println("Por favor digite o valor a ser transferdio para a conta poupança: ");
                                    contacorrente.operacao(scan,contacorrente,contapoupança,true);
                                }
                            }
                            break;

                        }
                        else if(escolhamenu==2){
                            while(escolhamenu!=5) {
                                escolhamenu = 0;
                                menu.menuconta();
                                escolhamenu = scan.nextInt();
                                contapoupança.setSaldo(contapoupança.getSaldo()+contapoupança.reajuste(contapoupança.getSaldo(),10));

                                if (escolhamenu == 1) {
                                    escolhamenu = 0;
                                    System.out.println("Saldo atual: " + contapoupança.getSaldo());

                                } else if (escolhamenu == 2) {
                                    escolhamenu = 0;
                                    double deposito;
                                    System.out.println("Por favor digite o valor a ser depositado: ");
                                    deposito= scan.nextInt();
                                    contapoupança.setSaldo(contapoupança.operacao(contapoupança.getSaldo(),deposito));

                                } else if (escolhamenu == 3) {
                                    escolhamenu = 0;
                                    double saque;
                                    System.out.println("Por favor digite o valor de saque: ");
                                        saque= scan.nextInt();
                                    if(contapoupança.getSaldo()>=saque){
                                        contapoupança.setSaldo(contapoupança.operacaosaque(contapoupança.getSaldo(),saque));
                                        System.out.println("Saque efetuado com sucesso\nSeu saldo atual é: "+contapoupança.getSaldo());
                                    }else{
                                        System.out.println("Saldo invalido efetue um depoisto");
                                    }

                                } else if (escolhamenu == 4) {
                                    escolhamenu = 0;
                                    System.out.println("Por favor digite o valor a ser transferdio para a conta corrente: ");
                                    contacorrente.operacao(scan,contacorrente,contapoupança,false);
                                }
                            }
                            break;


                        }








                    }else{System.out.println("CPF ou Senha invalidos" + "\n" + "Digite os dados novamente");
                    }


                }
            }

        }



    }
}
