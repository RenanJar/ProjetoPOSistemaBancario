import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class teste  {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList<>();
        int[] extrato = new int[10];
        int escolha=0;
        int deposito;
        int contadordeposito=0;
        Scanner scan = new Scanner(System.in);
        while (escolha!=2){
            System.out.println("um numero: ");
            deposito= scan.nextInt();
            deposito=deposito-(deposito*2);
            escolha=scan.nextInt();
            contadordeposito++;
            extrato[contadordeposito]=deposito;
        }
        for(int x=0;x<=20;x++){
            System.out.println(extrato[x]);
        }



    }




}
