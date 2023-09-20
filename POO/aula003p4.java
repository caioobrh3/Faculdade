package POO;

import java.util.Scanner;

public class aula003p4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = input.nextInt();

        System.out.println("Os 5 primeiros números primos após " + numero + " são:");
        exibirCincoPrimos(numero);
    }

    public static void exibirCincoPrimos(int numero) {
        int contador = 0;
        int numeroAtual = numero + 1;

        while (contador < 5) {
            if (ehPrimo(numeroAtual)) {
                System.out.println(numeroAtual);
                contador++;
            }
            numeroAtual++;
        }
    }

    public static boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}