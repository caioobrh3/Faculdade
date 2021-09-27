package br.ucsal;

import java.util.Scanner;

public class Pratica12 {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			double valor1, valor2,resultado;
			char cal;			 
			System.out.println("Digite o primeiro número");
			valor1 = scan.nextDouble();			
			System.out.println("Digite o segundo número");
			valor2 = scan.nextDouble();			
			System.out.println("Qual operação deseja realizar?(1)Soma(2)Subtrai(3)Multiplica(4)Divide");
			cal = scan.next().charAt(0);			
			if (cal == '1') {
				resultado = valor1 + valor2;
				System.out.println("O resultado da soma é: "+ resultado);
			} else if(cal == '2') {
				resultado = valor1 - valor2;
				System.out.println("O resultado da subtração é: "+ resultado);
			} else if(cal == '3') {
				resultado = valor1 * valor2;
				System.out.println("O resultado da multiplicação é: "+ resultado);	
			} else if(cal == '4') {
				resultado = valor1 / valor2;
				System.out.println("O resultado da divisão é: "+ resultado);					
			}else {
				System.out.println("Você não escolheu nenhuma operação");
			}
			scan.close();
 
	}

}
