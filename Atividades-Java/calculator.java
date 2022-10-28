package br.ucsal;

import java.util.Scanner;

public class calculator {
	
	/*Problem: build a calculator for, from 02 values Informed
    by the user as well as the choice of the operation to be performed, the algorithm
    present the final result. If the user does not choose any of the 04 operations
    basics: add, subtract, divide and multiply the algorithm should
    report invalid operation.*/

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double valor1, valor2,resultado;
		char cal;
		System.out.println("Primeiro Valor");
		valor1 = scan.nextDouble();
		System.out.println("segundo Valor");
		valor2 = scan.nextDouble();
		System.out.println("escolha qual operaçao deseja  \n (1)Soma \n (2)subtrair \n (3)dividir \n (4)multiplicar ");
		cal = scan.next().charAt(0);
        if (cal == '1') {
        	resultado = valor1 + valor2 ;
        	System.out.println("o Resultado da operaçao é " + resultado);
        } else if  (cal == '2') {
        	resultado = valor1 - valor2;
        	System.out.println("o Resultado da operaçao é " + resultado);       
        } else if  (cal == '3') {
        	resultado = valor1 / valor2;
        	System.out.println("o Resultado da operaçao é " + resultado);  
        } else if  (cal == '4') {
        	resultado = valor1 * valor2;
        	System.out.println("o Resultado da operaçao é " + resultado); 
        }else {
        	System.out.println("não escolheu nenhuma opçao");
        }
        scan.close();
       
        	

	}

}
