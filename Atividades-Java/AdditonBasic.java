package br.ucsal;

import java.util.Scanner;

public class AdditonBasic {
	
	/* The object of the code is add 2 values
	and to introduce the result in the screen */

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		System.out.println("Usuario informe o primeiro valor");
		int valor1 = sc.nextInt();
		System.out.println("Usuario informe o segundo valor");
		int valor2 = sc.nextInt();
		System.out.println("o usuario informou os valores " + valor1 + " e " + valor2);
		int res = valor1 + valor2;
		System.out.println("O resutado da soma é " +res);
		
	}

}
