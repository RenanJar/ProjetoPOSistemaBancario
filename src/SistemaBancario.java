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
                conta.setNome(scan.next());
                ///ponto a melhorar nome com sobre nome
                ///exception???
                System.out.println("Por favor digite seu CPF");
                conta.setCPF(scan.nextInt());
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
                    int cpf;
                    cpf = scan.nextInt();
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
                                    deposito=contacorrente.getSaldo();
                                    deposito+= scan.nextInt();
                                    contacorrente.setSaldo(deposito);


                                } else if (escolhamenu == 3) {
                                    escolhamenu = 0;
                                    double saque;
                                    System.out.println("Por favor digite o valor de saque: ");
                                    saque=contacorrente.getSaldo();
                                    saque-= scan.nextInt();
                                    contacorrente.setSaldo(saque);


                                } else if (escolhamenu == 4) {
                                    escolhamenu = 0;
                                    System.out.println("Por favor digite o valor a ser transferdio para a conta poupança: ");
                                    double maistransferencia;
                                    double menostransferencia;
                                    double transferencia;
                                    menostransferencia=contacorrente.getSaldo();
                                    transferencia= scan.nextInt();
                                    menostransferencia-= transferencia;
                                    contacorrente.setSaldo(menostransferencia);
                                    maistransferencia=contapoupança.getSaldo();
                                    maistransferencia+=transferencia;
                                    contapoupança.setSaldo(maistransferencia);

                                    System.out.println(contapoupança.getSaldo());
                                    System.out.println(contacorrente.getSaldo());

                                }
                            }
                            break;

                        }
                        else if(escolhamenu==2){
                            while(escolhamenu!=5) {
                                escolhamenu = 0;
                                menu.menuconta();
                                escolhamenu = scan.nextInt();

                                if (escolhamenu == 1) {
                                    escolhamenu = 0;
                                    System.out.println("Saldo atual: " + contapoupança.getSaldo());

                                } else if (escolhamenu == 2) {
                                    escolhamenu = 0;
                                    double deposito;
                                    System.out.println("Por favor digite o valor a ser depositado: ");
                                    deposito=contapoupança.getSaldo();
                                    deposito+= scan.nextInt();
                                    contapoupança.setSaldo(deposito);


                                } else if (escolhamenu == 3) {
                                    escolhamenu = 0;
                                    double saque;
                                    System.out.println("Por favor digite o valor de saque: ");
                                        saque= scan.nextInt();
                                    if(contapoupança.getSaldo()>=saque){
                                        contapoupança.setSaldo(contapoupança.getSaldo()-saque);
                                    }else{
                                        System.out.println("Saldo invalido efetue um depoisto");
                                    }

                                } else if (escolhamenu == 4) {
                                    escolhamenu = 0;
                                    System.out.println("Por favor digite o valor a ser transferdio para a conta corrente: ");
                                    double maistransferencia;
                                    double menostransferencia;
                                    double transferencia;
                                    menostransferencia=contapoupança.getSaldo();
                                    transferencia= scan.nextInt();
                                    menostransferencia-= transferencia;
                                    contapoupança.setSaldo(menostransferencia);
                                    maistransferencia=contacorrente.getSaldo();
                                    maistransferencia+=transferencia;
                                    contacorrente.setSaldo(maistransferencia);

                                    System.out.println(contapoupança.getSaldo());
                                    System.out.println(contacorrente.getSaldo());

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
