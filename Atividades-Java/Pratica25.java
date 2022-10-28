package br.ucsal;

import java.util.Scanner;

public class Pratica25 {

	public static void main(String[] args) {
		
		int inicio = 1900 , fim = 2032;
		while(inicio <= fim){
			if ( (inicio % 4 == 0 && inicio % 100 != 0) || inicio % 400 == 0 ){
				System.out.println("Ano Bisexto: "+inicio);
				inicio = inicio+4;
			}else{
				inicio++;
			}
		}
	}
}