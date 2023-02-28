package aula02;
import java.util.Scanner;


public class aula002p7 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero inteiro: ");
        int numero = scanner.nextInt();

        int fatorial = calcularFatorial(numero);

        System.out.println(numero + "! = " + fatorial);
    }

    public static int calcularFatorial(int numero) {
        int fatorial = 1;

        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }

        return fatorial;
    }
}