package br.ucsal;

import java.util.Scanner;

public class Pratica13 {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			double valor1, valor2,resultado;
			char cal;			 
			System.out.println("Digite o primeiro n�mero");
			valor1 = scan.nextDouble();			
			System.out.println("Digite o segundo n�mero");
			valor2 = scan.nextDouble();			
			System.out.println("Qual opera��o deseja realizar?(1)Soma(2)Subtrai(3)Multiplica(4)Divide");
			cal = scan.next().charAt(0);			
			if (cal == '1') {
				resultado = valor1 + valor2;
				System.out.println("O resultado da soma �: "+ resultado);
			} else if(cal == '2') {
				resultado = valor1 - valor2;
				System.out.println("O resultado da subtra��o �: "+ resultado);
			} else if(cal == '3') {
				resultado = valor1 * valor2;
				System.out.println("O resultado da multiplica��o �: "+ resultado);	
			} else if(cal == '4') {
				resultado = valor1 / valor2;
				System.out.println("O resultado da divis�o �: "+ resultado);					
			}else {
				System.out.println("Voc� n�o escolheu nenhuma opera��o");
			}
			scan.close();
 
	}

}
