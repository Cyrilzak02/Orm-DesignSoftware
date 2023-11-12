package Apresentacao;

import Entidades.Cliente;
import Entidades.Jogo;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ClienteBibliotecaApresentacao {

    public static List<Jogo> obterJogosDoCliente (Cliente cliente) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
        EntityManager em = emf.createEntityManager();
        try {
            // Assuming the association between Biblioteca and Jogo is mapped correctly
            String jpql = "SELECT j FROM Jogo j JOIN j.bibliotecas b WHERE b.cliente = :cliente";
            em.getTransaction().begin();
    		em.getTransaction().commit();
    		em.close();
    		emf.close();
            return em.createQuery(jpql, Jogo.class)
                    .setParameter("cliente", cliente)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception according to your needs
            System.out.println("lista vazia");
            return null;
        }
    }
}