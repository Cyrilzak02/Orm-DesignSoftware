// ClienteDados.java
package Dados;

import java.util.Iterator;
import java.util.List;

import Entidades.Cliente;
import Negocios.ClienteNegocio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ClienteDados {
	
	public  void cadastrarCliente(Cliente cliente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();
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
	    em.close();
	}
	

    public  Cliente fazerLogin(String cpf) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();

        
            // Consulta para encontrar o cliente com base no e-mail
            String jpql = "SELECT c FROM Cliente c WHERE c.cpf = :cpf"; //aqui tem que colocar como se o o cliente for achado , no negocio vc coloca a validacao (se nao for achado)
            TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
            query.setParameter("cpf", cpf);

            // Tenta obter o cliente com o e-mail fornecido
            
            Cliente cliente =  query.getSingleResult();
            em.close();
            return cliente;
        
            
        
    }
    public  boolean verificarClienteExistente(String cpf) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();
        // Consulta JPQL para verificar se já existe um cliente com o mesmo CPF
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class)
                                    .setParameter("cpf", cpf)
                                    .getResultList();
        
        for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
			
		}
        em.close();
        // Se a lista de clientes não estiver vazia, significa que já existe um cliente com o mesmo CPF
        return !clientes.isEmpty();
    }
    public static void adicionarSaldo(Cliente cliente, float valor) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		cliente.setSaldo(cliente.getSaldo() + valor);
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();
    }
    
    
    
}
