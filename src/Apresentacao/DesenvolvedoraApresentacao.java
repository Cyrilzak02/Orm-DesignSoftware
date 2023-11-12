package Apresentacao;

import Entidades.Desenvolvedora;
import Entidades.Jogo;
import Negocios.DesenvolvedoraNegocios;
import java.util.*;
public class DesenvolvedoraApresentacao {
         public Desenvolvedora preencherDesenvolvedora() {
        	 Scanner in = new Scanner(System.in);
        	 
        	 System.out.println("================= Digite o nome da empresa: =================");
        	 String nome = in.next();
        	 System.out.println("================= Digite o cnpj da empresa: =================");
        	 String cnpj = in.next();
        	 System.out.println("================= Digite o endereco da empresa: =================");
        	 String endereco = in.next();
        	 
        	 return new Desenvolvedora(nome,cnpj,endereco);
        	 
         }
         
         public String fazerLoginDesenvolvedora() {
        	 Scanner in = new Scanner(System.in);
        	 System.out.println("================= Digite o cnpj da empresa: =================");
        	 String cnpj = in.next();
        	 
        	 
        	 return cnpj;
        	 
         }
         public boolean atualizar_Versao(Desenvolvedora desenvolvedora) {
        	 DesenvolvedoraNegocios des = new DesenvolvedoraNegocios();
        	 System.out.println("Escolhe um jogo para atualizar a versao:(Digitar numero)");
        	 Scanner in = new Scanner(System.in);
				int index = in.nextInt();
			System.out.println("Digita a nova versao: ");
			float versao = in.nextFloat();
			
			return des.atualizarVersao(desenvolvedora, index, versao);
				
         }
         public boolean deleteJogo(Desenvolvedora desenvolvedora) {
        	 DesenvolvedoraNegocios des = new DesenvolvedoraNegocios();
        	 System.out.println("Escolhe um jogo que voce deseja remover:(Digitar numero)");
        	 Scanner in = new Scanner(System.in);
				int index = in.nextInt();
			
			
			return des.deleteJogo(desenvolvedora, index);
				
         }
         
         
         
}
