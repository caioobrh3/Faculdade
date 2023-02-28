package aula02;
import java.util.Scanner;

public class aula002p8 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero inteiro: ");
        int numero = scanner.nextInt();

        boolean primo = verificarPrimo(numero);

        if (primo) {
            System.out.println(numero + " e um numero primo");
        } else {
            System.out.println(numero + " nao e um numero primo");
        }
    }

    public static boolean verificarPrimo(int numero) {
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
