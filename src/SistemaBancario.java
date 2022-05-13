import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {

        int escolha= 0;
        Menu menu= new Menu();
        Conta conta=new Conta();
        Contacorrente contacorrente = new Contacorrente();
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

                    if (cpf == conta.getCPF() && senha == conta.getSenha()) {
                        System.out.println("Bem vinde "+conta.getNome());


                    } else {
                        System.out.println("CPF ou Senha invalidos" + "\n" + "Digite os dados novamente");
                        sair=10;
                    }
                }
            }

        }



    }
}
