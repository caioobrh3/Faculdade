package POO;

import java.util.Scanner;

public class aula003p3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Qual a idade do nadador? ");
        int idade = input.nextInt();

        exibirCategoriaNadador(idade);
    }

    public static void exibirCategoriaNadador(int idade) {
        if (idade >= 5 && idade <= 7) {
            System.out.println("Infantil A");
        } else if (idade >= 8 && idade <= 10) {
            System.out.println("Infantil B");
        } else if (idade >= 11 && idade <= 13) {
            System.out.println("Juvenil A");
        } else if (idade >= 14 && idade <= 17) {
            System.out.println("Juvenil B");
        } else {
            System.out.println("Sênior");
        }
    }
}