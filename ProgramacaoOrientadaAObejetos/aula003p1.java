package POO;
import java.util.Scanner;

public class aula003p1 {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Quantos alunos tem na turma? ");
        int numAlunos = input.nextInt();

        for (int i = 1; i <= numAlunos; i++) {
            System.out.println("\nAluno #" + i);
            System.out.print("Nome: ");
            String nome = input.next();

            double somaNotas = 0;
            for (int j = 1; j <= 4; j++) {
                System.out.printf("Nota %d: ", j);
                double nota = input.nextDouble();
                somaNotas += nota;
            }
            double media = somaNotas / 4;

            exibirResultado(nome, media);
        }
    }

    public static void exibirResultado(String nome, double media) {
        if (media >= 7.0) {
            System.out.printf("Parabens, %s, voce foi aprovado.\n", nome);
        } else if (media >= 4.0 && media < 7.0) {
            System.out.printf("%s, apresente-se para a prova final.\n", nome);
        } else {
            System.out.printf("%s, infelizmente voce não atingiu a media minima.\n", nome);
        }
    }
}