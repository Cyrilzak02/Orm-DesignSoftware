package Apresentacao;






import Entidades.Cliente;
import Entidades.Desenvolvedora;
import java.util.List;
import java.util.Scanner;

import javax.swing.ListCellRenderer;

import Dados.DesenvolvedoraDados;

import Dados.DesenvolvedoraDados;











import Entidades.*;
public class Principal {
	public static ClienteApresentacao clienteApresentacao = new ClienteApresentacao();
	public static ClienteNegocio clienteNegocio = new ClienteNegocio();
	public static DesenvolvedoraApresentacao desenvolvedoraApresentacao = new DesenvolvedoraApresentacao();
	public static DesenvolvedoraNegocios desenvolvedoraNegocios = new DesenvolvedoraNegocios();
	public static void main(String [] args) {
		
		
	    Cliente cliente = new Cliente();
	    Desenvolvedora desenvolvedora = new Desenvolvedora();
	    ClienteApresentacaoSaldo clienteapresentacaosaldo= new ClienteApresentacaoSaldo();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Entrar como Desenvolvedora ou Cliente?(C/D else sair)");
		String escolha = in.next();
		Boolean cadastrou = false;
		if(escolha.equals("C")) {
			while (true) {
			System.out.println("[1]- Cadastrar.");
			System.out.println("[2]- Login.");
			System.out.print("Resposta: ");
			String option = in.next();
			if(option.equals("1")) {
				cliente = clienteApresentacao.cadastrarCliente();
				cadastrou =clienteNegocio.cadastrarCliente(cliente);
				if(cadastrou) {
					break;
				}
				System.out.println("Cliente ja cadastrado.");
				}
			if(option.equals("2")) {
				String cpf = clienteApresentacao.loginCliente();
				cliente =clienteNegocio.loginCliente(cpf); 
				
				if(cliente == null) {
					System.out.println("Cpf nao cadastrado");
				}
				else {
					System.out.println("Login realizado com sucesso");
					while (true) {
                        System.out.println("[1]- Adicionar Saldo.");
                        System.out.println("[2]- vizualizar biblioteca de jogos.");
                        
                        //add outros funcoes depois
                        System.out.print("Resposta: ");
                        String op = in.next();
                        if(op.equals(1)) {;
                        	float valorAdicionar = clienteapresentacaosaldo.obterValorAdicionar();
                        	ClienteDados.adicionarSaldo(cliente, valorAdicionar);
                        }else if(op.equals(2)) {
                        	List<Jogo> jogosDoCliente = ClienteBibliotecaApresentacao.obterJogosDoCliente(cliente);
                        	for (Jogo jogo : jogosDoCliente) {
                        	    System.out.println("Nome do Jogo: " + jogo.getNomeJogo());               
                        	    System.out.println("----------------------");
                        	}
                        }
                        	
                    }
                    
                    
				}
				
			}
			else {
				System.out.println("Input errada. Tenta de novo.");
			}
			
			
		}
			
		}
		
		if(escolha.equals("D")) {
			while (true) {
			System.out.println("[1]- Cadastrar.");
			System.out.println("[2]- Login.");
			System.out.print("Resposta: ");
			String option = in.next();
			if(option.equals("1")) {
				desenvolvedora= desenvolvedoraApresentacao.preencherDesenvolvedora();
				cadastrou =desenvolvedoraNegocios.cadastrarDesenvolvedora(desenvolvedora);
				if(cadastrou) {
					break;
				}
				System.out.println("Desenvolvedora ja cadastrada.");
				}
			if(option.equals("2")) {
				String cnpj = desenvolvedoraApresentacao.fazerLoginDesenvolvedora();
				desenvolvedora =desenvolvedoraNegocios.loginDesenvolvedora(cnpj); 
				
				if(desenvolvedora == null) {
					System.out.println("Cnpj nao cadastrado");
				}
				else {
					System.out.println("Login realizado com sucesso");
					break;
				}
			}
			else {
				System.out.println("Input errada. Tenta de novo.");
			}
			}
			
			
		}
			
		}
		
		
		}


