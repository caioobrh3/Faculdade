package EstruturaDDS.Aula;

import java.util.Random;

public class NumerosIguais {
    public static void main(String[] args) {
        Random random = new Random();
        
        int[] numeros = new int[10];
        
        for (int i = 0; i < 10; i++) {
            numeros[i] = random.nextInt(11); 
        }
        
      
        System.out.println("Números gerados:");
        for (int i = 0; i < 10; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        
    
        boolean encontrouIgual = false;
        
        System.out.println("Números iguais:");
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (numeros[i] == numeros[j]) {
                    System.out.println(numeros[i]);
                    encontrouIgual = true;
                }
            }
        }
        
        if (!encontrouIgual) {
            System.out.println("sem numeros repitidos");
        }
    }
}
