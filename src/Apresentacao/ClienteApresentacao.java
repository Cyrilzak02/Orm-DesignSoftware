package Apresentacao;
import Entidades.Cliente;
import Entidades.Desenvolvedora;

import java.util.*;
public class ClienteApresentacao {
	public static Scanner in = new Scanner (System.in);
       public Cliente cadastrarCliente() {
    	   Scanner in = new Scanner(System.in);
      	 
      	 System.out.println("================= Digite o nome: =================");
      	 String nome = in.next();
      	 System.out.println("================= Digite o email: =================");
      	 String email = in.next();
      	 System.out.println("================= Digite o cpf: =================");
      	 String cpf = in.next();
      	System.out.println("================= Digite o endereco: =================");
     	 String endereco = in.nextLine();
      	 return new Cliente(nome,email,cpf,endereco);
       }
       public String loginCliente() {
    	   System.out.println("Informar CPF");
    	   String cpf= in.next();
    	   
    	   return cpf;
    	  
    	   
    	   
       }
}
