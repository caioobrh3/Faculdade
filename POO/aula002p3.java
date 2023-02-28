package aula02;
import java.util.Scanner;

public class aula002p3 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int valor;
        
        do {
            System.out.print("Digite um valor entre 0 e 100: ");
            valor = scanner.nextInt();
        } while (valor < 0 || valor > 100);
        
        System.out.println("O valor digitado foi: " + valor);
    }
}
