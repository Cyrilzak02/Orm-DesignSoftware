package Apresentacao;

import java.util.Scanner;

import Entidades.*;

public class JogoApresentacao {
	public Jogo cadastrarJogo() {
		 Scanner in = new Scanner(System.in);
    	 
    	 System.out.println("================= Digite o nome do Jogo: =================");
    	 String nome = in.nextLine();
    	 System.out.println("================= Digite o tipo do Jogo: =================");
    	 String tipoJogo = in.nextLine();
    	 System.out.println("================= Digite o tamanho do jogo =================");
    	 float tamanho = in.nextFloat();
    	 System.out.println("================= Digite o preco do jogo =================");
    	 float preco = in.nextFloat();
    	 System.out.println("================= Digite a versao do jogo: =================");
    	 float versao = in.nextFloat();
    	 
    	 return new Jogo(nome , tipoJogo, tamanho, preco , versao) ;
    	 
		
	}
}
