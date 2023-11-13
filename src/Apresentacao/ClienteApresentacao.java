package Apresentacao;
import Entidades.Cliente;
import Entidades.Desenvolvedora;
import Entidades.Jogo;
import Dados.*;
import Negocios.*;

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
       public String comprarJogo(Cliente cliente) {
    	   JogoDados jogoDados = new JogoDados();
    	   List<Jogo> jogos = jogoDados.listarJogos();
    	   
    	   for(int i =0 ; i<jogos.size();i++) {
    		   System.out.println(i+" - "+jogos.get(i).getNomeJogo() + " Preco: "+ jogos.get(i).getPreco());
    	   }
    	   System.out.println("Escolhe um jogo para comprar:(Digitar o numero do jogo)");
    	   int index = in.nextInt();
    	   ClienteNegocio clienteNegocio = new ClienteNegocio();
    	   
    	   return clienteNegocio.comprarJogo(cliente, jogos.get(index));
    	  
    	   
       }
}
