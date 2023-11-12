package Entidades;

import dados.ClienteDados;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
        EntityManager em = emf.createEntityManager();

    }
}
