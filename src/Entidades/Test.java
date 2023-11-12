package Entidades;

import jakarta.persistence.EntityManager;
import Dados.DesenvolvedoraDados;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class Test {

	
	public static void main(String[] args) {
		
		
		Desenvolvedora d = new Desenvolvedora("Ubisoft" , "32219303993" ,"Puta qui pariu");
		
		DesenvolvedoraDados.cadastrar(d) ; 
		
		
		
		 
		
	}
}
