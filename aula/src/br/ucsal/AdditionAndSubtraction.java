package br.ucsal;

import java.util.Scanner;

public class AdditionAndSubtraction{

	/* Problem: come up with a solution to create a calculator where the user
      must enter two values ​And choose which basic operation you want
      perform: add or subtract. Then the algorithm should show
      the result of the operation chosen by the user. */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double valor1, valor2, resultado;
		int operacao;
		System.out.println("Digite o primeiro numero: ");
		valor1 = sc.nextDouble();
		System.out.println("Digite o segundo numero: ");
		valor2 = sc.nextDouble();
		System.out.println("Informe a operação: (1) Somar ou (2) Subtrair");
		operacao = sc.nextInt();
		if (operacao == 1) {
			resultado = valor1 + valor2;
		} else if (operacao == 2) {
			resultado = valor1 - valor2;
		} else {
			resultado = 0;
		}
		System.out.println("O usuario escolheu a operação " + operacao);
		System.out.println("O resultado é " + resultado);
		sc.close();
	}

}