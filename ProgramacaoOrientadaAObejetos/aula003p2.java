package POO;
import java.util.Scanner;

public class aula003p2 {

	public static void main(String[] args) {
	       Scanner input = new Scanner(System.in);

	        System.out.print("Qual a sua idade? ");
	        int idade = input.nextInt();

	        exibirCategoriaVoto(idade);
	    }

	    public static void exibirCategoriaVoto(int idade) {
	        if (idade < 16) {
	            System.out.println("Sem permissao para votar.");
	        } else if (idade >= 16 && idade <= 17 || idade >= 65) {
	            System.out.println("Voto facultativo.");
	        } else {
	            System.out.println("Voto obrigatorio.");
	        }
	    }
	}
