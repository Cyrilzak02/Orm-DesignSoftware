package Negocios;

import Entidades.Cliente;
import jakarta.persistence.EntityManager;
import java.util.List;

import 	Dados.ClienteDados;

public class ClienteNegocio {
	
	private ClienteDados clienteDados = new ClienteDados();

    public  Boolean cadastrarCliente(Cliente cliente) {
        // Verifica se já existe um cliente com o mesmo CPF
        if (this.clienteDados.verificarClienteExistente(cliente.getCpf())) {
            return false;
            
        }
          
        
        clienteDados.cadastrarCliente(cliente);
        return true;
        
        }
    public Cliente loginCliente(String cpf) {
        // Verifica se já existe um cliente com o mesmo CPF
        if (!this.clienteDados.verificarClienteExistente(cpf)) {
            return null;
            
        }
          
        
        return clienteDados.fazerLogin(cpf);
        
        
        }
    }

    

