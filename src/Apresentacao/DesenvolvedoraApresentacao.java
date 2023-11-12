package Apresentacao;

import Entidades.Desenvolvedora;
import java.util.*;
public class DesenvolvedoraApresentacao {
         public Desenvolvedora preencherDesenvolvedora() {
        	 Scanner in = new Scanner(System.in);
        	 
        	 System.out.println("================= Digite o nome da empresa: =================");
        	 String nome = in.next();
        	 System.out.println("================= Digite o cnpj da empresa: =================");
        	 String cnpj = in.next();
        	 System.out.println("================= Digite o endereco da empresa: =================");
        	 String endereco = in.nextLine();
        	 
        	 return new Desenvolvedora(nome,cnpj,endereco);
        	 
         }
         
         public String fazerLoginDesenvolvedora() {
        	 Scanner in = new Scanner(System.in);
        	 System.out.println("================= Digite o cnpj da empresa: =================");
        	 String cnpj = in.next();
        	 
        	 
        	 return cnpj;
        	 
         }
}
