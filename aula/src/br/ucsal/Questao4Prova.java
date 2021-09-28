package br.ucsal;

import java.util.Scanner;

public class Questao4Prova {

	public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        int valor1, valor2, valor3;
        System.out.println("Digite o primeiro valor:");
        valor1 = sc.nextInt();
        System.out.println("Digite o segundo valor:");
        valor2 = sc.nextInt();
        System.out.println("Digite o terceiro valor:");
        valor3 = sc.nextInt();
        
        if (valor1 > 20){
            System.out.println("Valor incorreto Informe os valores Entre 1 e 20!");
        } else if (valor2 > 20){
        	System.out.println("Valor incorreto Informe os Entre 1 e 20!");
        } else if (valor3 > 20){
        	System.out.println("Valor incorreto Informe os Entre 1 e 20!");
            
        }else if (valor1 > valor2) {
        	if(valor2 > valor3) {
        		System.out.println(valor1+"\n"+valor2+"\n"+valor3);
        	}
        	else if (valor1 > valor3) {
        		System.out.println(valor1+"\n"+valor3+"\n"+valor2);
        	}else {
        		System.out.println(valor3+"\n"+valor1+"\n"+valor2);
        	}
        

        }
        else if (valor2 > valor3) {
        	if(valor1 > valor3) {
        		System.out.println(valor2+"\n"+valor1+"\n"+valor3);
        	} else {
        		System.out.println(valor2+"\n"+valor3+"\n"+valor1);
        	}
        	} else {
        		System.out.println(valor3+"\n"+valor2+"\n"+valor1);
        	}
        

        }


    }
    
