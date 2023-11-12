package Entidades;

import jakarta.persistence.EntityManager;

import Negocios.DesenvolvedoraNegocios;
import Dados.DesenvolvedoraDados;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class Test {

	
	public static void main(String[] args) {
		
		
		
		Desenvolvedora d = new Desenvolvedora("RocketStar" , "322193453992" ,"Puta qui pariu");
		
		DesenvolvedoraNegocios desenvolvedoraNegocios = new DesenvolvedoraNegocios();
		
		
		
		System.out.print(desenvolvedoraNegocios.cadastrarDesenvolvedora(d));
		
		Jogo jogo = new Jogo( "Pussy" , "Action", 2.0f, 200.0f , 1.0f);
		
	    DesenvolvedoraDados.publicarJogo(d,jogo);
		
		
		
		
		
		
		
		
		 
		
	}
}
