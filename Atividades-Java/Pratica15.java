package br.ucsal;

import java.util.Scanner;

public class Pratica15 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Informe o número do dia da semana ");
			int diaSemana = sc.nextInt();
				
			switch (diaSemana) {
				case 1:
					System.out.println("domingo");
					break;
				case 2:
					System.out.println("segunda");
					break;
				case 3:
					System.out.println("terça");
					break;
				case 4:
					System.out.println("quarta");
					break;
				case 5:
					System.out.println("quita");
					break;
				case 6:
					System.out.println("sexta");
					break;
				case 7:
					System.out.println("sabado");
					break;
				default:
					System.out.println("Dia inválido. Tente novamente");
					break;
					
				}
		}
		}
		
}


