package br.ucsal;

import java.util.Scanner;

public class Pratica14 {

	   public static void main(String[] args) {
	       @SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
	       int valor1, valor2, valor3;
	 
	       System.out.println("Informe um valor inteiro entre 10 e 20  e que não pode ser repetido: ");
	       valor1 = entrada.nextInt();
	 
	       System.out.println("Informe um valor inteiro entre 10 e 20  e que não pode ser repetido: ");
	       valor2 = entrada.nextInt();
	 
	       System.out.println("Informe um valor inteiro entre 10 e 20  e que não pode ser repetido: ");
	       valor3 = entrada.nextInt();
	 
	       if(valor1 == valor2 && valor2 == valor3 && valor1 == valor3){
	           System.out.println("Informe os valores conforme o descrito!");
	       } else if (valor1 < 1 || valor1 > 20){
	           System.out.println("Informe os valores conforme o descrito!");
	       } else if (valor2 < 1 || valor2 > 20){
	           System.out.println("Informe os valores conforme o descrito!");
	       } else if (valor3 < 1 || valor3 > 20){
	           System.out.println("Informe os valores conforme o descrito!");
	       } else if(valor1 > valor2 && valor1 > valor3){
	           System.out.println("O maior valor é: " +valor1);
	 
	           if(valor2 < valor1 && valor2 < valor3){
	               System.out.println("O menor valor é: " +valor2);
	           } else if(valor3 < valor1 && valor3 < valor2){
	               System.out.println("O menor valor é: " +valor3);
	           }
	 
	       } else if(valor2 > valor1 && valor2 > valor3){
	           System.out.println("O maior valor é: " +valor2);
	 
	           if(valor1 < valor2 && valor1 < valor3){
	               System.out.println("O menor valor é: " +valor1);
	           } else if(valor3 < valor1 && valor3 < valor2){
	               System.out.println("O menor valor é: " +valor3);
	           }
	 
	       } else if(valor3 > valor1 && valor3 > valor2){
	           System.out.println("O maior valor é: " +valor3);
	 
	           if(valor1 < valor2 && valor1 < valor3){
	               System.out.println("O menor valor é: " +valor1);
	           } else if(valor2 < valor3 && valor2 < valor1){
	               System.out.println("O menor valor é: " +valor3);
	           }
	       }
	 
	   }
	}
