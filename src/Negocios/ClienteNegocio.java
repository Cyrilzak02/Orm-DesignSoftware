package Negocios;

import Entidades.Cliente;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ClienteNegocio {

    public static void cadastrarCliente(Cliente cliente, EntityManager em) {
        // Verifica se já existe um cliente com o mesmo CPF
        if (verificarClienteExistente(cliente.getCpf(), em)) {
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

    public static boolean verificarClienteExistente(String cpf, EntityManager em) {
        // Consulta JPQL para verificar se já existe um cliente com o mesmo CPF
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class)
                                    .setParameter("cpf", cpf)
                                    .getResultList();

        // Se a lista de clientes não estiver vazia, significa que já existe um cliente com o mesmo CPF
        return !clientes.isEmpty();
    }
}

