// ClienteDados.java
package dados;

import Entidades.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ClienteDados {

    public static Cliente fazerLogin(String email) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();

        try {
            // Consulta para encontrar o cliente com base no e-mail
            String jpql = "SELECT c FROM Cliente c WHERE c.email = :email";
            TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
            query.setParameter("email", email);

            // Tenta obter o cliente com o e-mail fornecido
            return query.getSingleResult();
        } catch (NoResultException e) {
            // Nenhum cliente encontrado com o e-mail fornecido
            return null;
        } finally {
            em.close(); // Certifique-se de fechar o EntityManager
        }
    }
}
