package POO;
import java.util.Scanner;

public class aula002p2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um numero inteiro: ");
        int num = input.nextInt();

        int prev = 0;
        int curr = 0;
        while (true) {
            System.out.print("Digite um numero: ");
            curr = input.nextInt();

            if (prev + curr == num) {
                System.out.println("Soma encontrada: " + prev + " + " + curr + " = " + num);
                break;
            }

            prev = curr;
        }

        input.close();
    }
}