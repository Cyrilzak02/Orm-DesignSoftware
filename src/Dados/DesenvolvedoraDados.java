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

import Entidades.Desenvolvedora;

public class DesenvolvedoraDados {
	public static void cadastrar(Desenvolvedora desenvolvedora) {
             
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
        EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

        // Use JPQL to fetch all books
		String jpql = "SELECT d FROM Desenvolvedora d WHERE d.cnpj = '"+ desenvolvedora.getCnpj()+"'";
		List<Desenvolvedora> desenvolvedoras = em.createQuery(jpql, Desenvolvedora.class).getResultList();

        // Commit the transaction
        em.getTransaction().commit();

        // Close the EntityManager
        em.close();
        emf.close();
        
        for (Desenvolvedora desenvolvedor : desenvolvedoras) {
            System.out.println("Cnpj " + desenvolvedor.getCnpj());
        }
		
		
		
		
		
	}
}
