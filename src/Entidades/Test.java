package Entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class Test {

	
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		Cliente c1 = new Cliente("Cyril Zakhia" ,"cyrilzakhia@hotmail.com","3810135342-62","Charmouta", biblioteca);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(c1);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		 
		
	}
}
