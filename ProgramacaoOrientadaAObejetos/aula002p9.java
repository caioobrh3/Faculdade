package POO;
import java.util.Scanner;


public class aula002p9 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um valor inteiro: ");
        int n = scanner.nextInt();

        double s = calcularSoma(n);

        System.out.println("S = " + s);
    }

    public static double calcularSoma(int n) {
        double soma = 0.0;

        for (int i = 1; i <= n; i++) {
            soma += 1.0 / i;
        }

        return soma;
}
}