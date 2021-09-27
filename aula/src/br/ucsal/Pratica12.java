package br.ucsal;

import java.util.Scanner;

public class Pratica12 {
	
	/*Problem: Develop a solution in JAVA to read the name, height, weight,
	 *  full address (separated by parts: street, number, neighborhood, 
	 *  zip code, city, state) and the user's status in the registry 
	 *  (active / inactive) informed by the user. The solution must return to 
	 *  the user an output printout containing the full name and address. For 
	 *  this solution, each element must be inserted in a specific variable, the 
	 *  initial title presented must be REGISTER.*/

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			String nome, bairro, cidade, estado, rua ;
			double altura, peso;
			int cep, numero;
			char resultado ;
			System.out.println("Informe o seu nome");
			nome = sc.next();
			System.out.println("Informe o seu peso");
			peso = sc.nextDouble();
			System.out.println("Informe o seu altura");
			altura = sc.nextDouble();
			System.out.println("informe Seu CEP");
			cep = sc.nextInt();
			System.out.println("Informe seu estado");
			estado = sc.next();
			System.out.println("informe sua Cidade");
			cidade = sc.next();
			System.out.println("informe seu bairro");
			bairro = sc.next();
			System.out.println("infome sua Rua");
			rua = sc.next();
			System.out.println("informe o numero de sua casa");
			numero = sc.nextInt();
			System.out.println("informe se está ativo ou inativo \n (1)Ativo \n (2)Inativo");
			resultado = sc.next().charAt(0);
			if ( resultado == '1') {
			System.out.println("Bem vindo " +nome+ " Este é seu peso e altura " +peso+" " +altura+ 
					", Esse é o seu endereço : " +cep+ " " +estado+ " " +cidade+ " " +bairro+ " " +rua+ " " +numero);
			}else {
			System.out.println("Por favor realize o cadastro");
			}
		}
	}

}
