package Dados;

import Entidades.Jogo;
import jakarta.persistence.*;

import java.util.List;

import Entidades.Desenvolvedora;

public class JogoDados {
	public static List listarJogos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
		String jpql = "SELECT j FROM Jogo j ";
		List<Jogo> jogos = em.createQuery(jpql, Jogo.class).getResultList();
		
		em.getTransaction().commit();

		
		em.close();
		emf.close();
		return jogos;
		
	}
	
	

}
