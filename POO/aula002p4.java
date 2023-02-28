package aula02;

import java.util.Scanner;


public class aula002p4 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPares = 0;
        int somaPares = 0;
        int countImpares = 0;
        int somaImpares = 0;
        int numero;

        while (countPares < 10) {
            System.out.print("Digite um numero: ");
            numero = scanner.nextInt();

            if (numero % 2 == 0) { 
                countPares++;
                somaPares += numero;
            } else { 
                countImpares++;
                somaImpares += numero;
            }
        }

        double mediaImpares = (double) somaImpares / countImpares;

        System.out.println("Soma dos numeros pares: " + somaPares);
        System.out.println("Media dos numeros mpares: " + mediaImpares);
    }
}