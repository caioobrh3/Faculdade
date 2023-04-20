package caio;

import java.util.Random;

public class SepararNumerosPares {
    public static void main(String[] args) {
        int[] numeros = new int[10];

        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1;
        }

        System.out.println("Lista de números:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        int[] numerosPares = new int[numeros.length];
        int contadorNumerosPares = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                numerosPares[contadorNumerosPares] = numeros[i];
                contadorNumerosPares++;
            }
        }

        System.out.println("Lista de números pares:");
        for (int i = 0; i < contadorNumerosPares; i++) {
            System.out.println(numerosPares[i]);
        }
    }
}
