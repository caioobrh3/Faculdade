package br.ucsal;

import java.util.Scanner;

public class Pratica16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int valor1, valor2,resultado;
		char cal;
		System.out.println("Primeiro Valor");
		valor1 = sc.nextInt();
		System.out.println("segundo Valor");
		valor2 = sc.nextInt();
		System.out.println("escolha qual operaçao deseja  \n (1)Soma \n (2)subtrair \n (3)dividir \n (4)multiplicar ");
		cal = sc.next().charAt(0);
		switch (cal) {
	    case 1:
        	resultado = valor1 + valor2 ;
		break;
	    case 2:
        	resultado = valor1 - valor2;
		break;
	    case 3:
        	resultado = valor1 / valor2;
		break;
	    case 4:
        	resultado = valor1 * valor2;
		break;
		
		default:
			resultado = 0;
		}
		System.out.println("o Resultado da operaçao é " + resultado);
	}

}
