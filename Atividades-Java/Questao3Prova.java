package br.ucsal;

import java.util.Scanner;

public class Questao3Prova {

	public static void main(String[] args) {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    
    System.out.println("Qual valor deseja converter");
    double total = sc.nextDouble();
    
    System.out.println("Qual � o tipo de moeda que que digitou \n (1)Real \n (2)Dolar \n (3)Euro");
    double moeda = sc.nextDouble();
    
    if (moeda == 1) {
    double cont = total * 0.19;
    System.out.println("O valor digitado em real convertido para dolar � " +cont+"$");
    double cont1 = total * 0.16;
    System.out.println("O valor digitado em real convertido para euro � " +cont1+"�");
    }if (moeda == 2) {
        double cont2 = total * 5.39;
        System.out.println("O valor digitado em Dolar convertido para Real � " +cont2+"R$");
        double cont3 = total * 6.30;
        System.out.println("O valor digitado em Dolar convertido para euro � " +cont3+"�");
    }if (moeda == 3) {
        double cont4 = total * 1.17;
        System.out.println("O valor digitado em euro convertido para Dolar � " +cont4+"$");
        double cont5 = total * 6.30;
        System.out.println("O valor digitado em euro convertido para Real � " +cont5+"R$");   	
    }

	}

}
