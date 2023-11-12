package Entidades;
import dados.ClienteDados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class Test {

	
	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("Cyril Zakhia" ,"cyrilzakhia@hotmail.com","3810135342-62","Charmouta");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogosOnlinePu");
		EntityManager em = emf.createEntityManager();
		
		// Suponha que você tenha um cliente com o email correto no banco de dados
        String email = "cyrilzakhia@hotmail.com";

        // Fazer login usando apenas o e-mail
        Cliente clienteLogado = ClienteDados.fazerLogin(email);

        // Verificar se o login foi bem-sucedido
        if (clienteLogado != null) {
            System.out.println("Login bem-sucedido. Cliente: " + clienteLogado.getNome());
            // Aqui você pode adicionar lógica adicional após um login bem-sucedido
        } else {
            System.out.println("Login falhou. Cliente não encontrado com o e-mail fornecido.");
            // Aqui você pode adicionar lógica adicional após um login mal-sucedido
        }
		
		em.getTransaction().begin();
		em.persist(c1);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		 
		
	}
}
