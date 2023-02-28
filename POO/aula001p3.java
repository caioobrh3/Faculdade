package POO;

import java.util.Scanner;

public class aula001p3 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Informe as 4 notas do aluno:");
        float nota1 = scanner.nextFloat();
        float nota2 = scanner.nextFloat();
        float nota3 = scanner.nextFloat();
        float nota4 = scanner.nextFloat();
        
        float media = (nota1 + nota2 + nota3 + nota4) / 4;
        
        if (media >= 7) {
            System.out.println("Aluno aprovado! sua media :"+media);
        } else {
            System.out.println("Aluno reprovado! sua media :"+media);
        }
        
        scanner.close();
    }
}