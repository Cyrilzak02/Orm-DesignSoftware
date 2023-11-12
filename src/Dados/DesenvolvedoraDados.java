package Dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import jakarta.persistence.*;
import java.util.*;


import Entidades.Jogo;
import Entidades.Desenvolvedora;

public class DesenvolvedoraDados {
	public static void cadastrar(Desenvolvedora desenvolvedora) {
             
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
        EntityManager em = emf.createEntityManager();
	
        
        
        	em.getTransaction().begin();
			em.persist(desenvolvedora);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			 
		}
	public static List consultaCnpj(Desenvolvedora desenvolvedora) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
        EntityManager em = emf.createEntityManager();
	    
        
        System.out.println(desenvolvedora.getCnpj()+"\n");
		String jpql = "SELECT d FROM Desenvolvedora d WHERE d.cnpj = '"+ desenvolvedora.getCnpj()+"'";
		List<Desenvolvedora> desenvolvedoras = em.createQuery(jpql, Desenvolvedora.class).getResultList();
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		

		
		em.close();
		emf.close();
		return desenvolvedoras;
	}
    
	public static Jogo publicarJogo(Desenvolvedora desenvolvedora, Jogo jogo) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
	    EntityManager em = emf.createEntityManager();

	    try {
	        // Check if there's an active transaction, and commit it if there is
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().commit();
	        }

	        // Start a new transaction
	        em.getTransaction().begin();

	        // Perform the query
	        Desenvolvedora existingDesenvolvedora = em.createQuery(
	                "SELECT d FROM Desenvolvedora d WHERE d.cnpj = :cnpj",
	                Desenvolvedora.class
	            )
	            .setParameter("cnpj", desenvolvedora.getCnpj())
	            .getSingleResult();

	        // Set the Desenvolvedora for the Jogo
	        jogo.setDes(existingDesenvolvedora);

	        // Persist the Jogo
	        em.persist(jogo);

	        // Commit the transaction
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        // If an exception occurs, rollback the transaction
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        // Close the EntityManager and EntityManagerFactory
	        em.close();
	        emf.close();
	    }

	    return jogo;
	}}
	
		
		
		
		
	

