// ClienteDados.java
package Dados;

import Entidades.Cliente;
import Negocios.ClienteNegocio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ClienteDados {
	
	public static void cadastrarCliente(Cliente cliente, EntityManager em) {
		if (ClienteNegocio.verificarClienteExistente(cliente.getCpf(), em)) {
            System.out.println("Erro ao cadastrar o cliente: CPF já cadastrado.");
            return;
        }
	    try {
	        // Inicie a transação
	        em.getTransaction().begin();

	        // Persista o cliente no banco de dados
	        em.persist(cliente);

	        // Commit da transação
	        em.getTransaction().commit();

	        System.out.println("Cliente cadastrado com sucesso!");
	    } catch (Exception e) {
	        // Se ocorrer um erro, faça rollback na transação
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        System.out.println("Erro ao cadastrar o cliente: " + e.getMessage());
	    }
	}
	

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
            em.close();
        }
    }
}
