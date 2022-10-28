package br.ucsal;

import java.util.Scanner;

public class Questao01Prova {

	public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	
    System.out.println("Quais numeros quer fazer a media ponderada (Entre 0 e 10)");
    double vl1 = sc.nextDouble(); double vl2 = sc.nextDouble(); double media;
    media = (vl1 * 3.8 + vl2 * 6.2) / 10 ;
    
    if (vl1 > 10){
        System.out.println("Valor incorreto Informe os valores Entre 0 e 10!");
    } else if (vl2 > 10){
    	System.out.println("Valor incorreto Informe os Entre 0 e 10!");
    } else if (media < 6) {
    	 System.out.println("A sua média é "+media+" Foi Reprovado ");   	
    }else {
    	System.out.println("A media é "+media+" Foi Aprovado ");
    }
    

	}

}
