package Dados;

import java.awt.Checkbox;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import jakarta.persistence.*;
import java.util.*;


import Entidades.Jogo;
import Entidades.Cliente;
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
	        existingDesenvolvedora.addListJogos(jogo);
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
	}
	
	public static Desenvolvedora fazerLoginDesenvolvedora(String cnpj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();

        
            // Consulta para encontrar o cliente com base no e-mail
            String jpql = "SELECT d FROM Desenvolvedora d WHERE d.cnpj = :cnpj"; //aqui tem que colocar como se o o cliente for achado , no negocio vc coloca a validacao (se nao for achado)
            TypedQuery<Desenvolvedora> query = em.createQuery(jpql, Desenvolvedora.class);
            query.setParameter("cnpj", cnpj);

            // Tenta obter o cliente com o e-mail fornecido
            
            Desenvolvedora desenvolvedora =  query.getSingleResult();
            em.close();
            return desenvolvedora;
	}
	public  boolean verificarDesenvolvedoraExistente(String cnpj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();
        // Consulta JPQL para verificar se já existe um cliente com o mesmo CPF
        List<Desenvolvedora> desenvolvedoras = em.createQuery("SELECT d FROM Desenvolvedora d WHERE d.cnpj = :cnpj", Desenvolvedora.class)
                                    .setParameter("cnpj", cnpj )
                                    .getResultList();

        // Se a lista de clientes não estiver vazia, significa que já existe um cliente com o mesmo CPF
        
        em.close();
        return !desenvolvedoras.isEmpty();
    }
	
	public boolean verificarJogos(Desenvolvedora desenvolvedora,Jogo jogo) {
		List<Jogo> jogos= desenvolvedora.getJogos();
		
		for(Jogo joga : jogos) {
			if(joga.getNomeJogo().equals(jogo.getNomeJogo())) {
				return true;
			}
			
		}
		return false;
	}
	
	public List listarJogos(Desenvolvedora desenvolvedora) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();
        // Consulta JPQL para verificar se já existe um cliente com o mesmo CPF
		List<Jogo> jogos = em.createQuery("SELECT j FROM Jogo j WHERE j.desenvolvedora = :desenvolvedora", Jogo.class)
                .setParameter("desenvolvedora", desenvolvedora)
                .getResultList();
        
        em.close();
        return jogos;

	}
	
	public void atualizarVersao(long id, float versao_nova) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();
		
		try {
		 em.getTransaction().begin();

	        // Retrieve the Jogo entity from the database
	        Jogo jogo = em.find(Jogo.class,id);
	        
	            // Update the field
	            jogo.setVersao(versao_nova);

	            // Commit the transaction to persist changes
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
		
	}
	
	
	


}
	
		
		
		
		
	

