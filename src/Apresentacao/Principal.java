package Apresentacao;

import java.util.Scanner;
import Entidades.Cliente;
import Entidades.Desenvolvedora;
import Negocios.ClienteNegocio;
import Negocios.DesenvolvedoraNegocios;



public class Principal {
	public static ClienteApresentacao clienteApresentacao = new ClienteApresentacao();
	public static ClienteNegocio clienteNegocio = new ClienteNegocio();
	public static DesenvolvedoraApresentacao desenvolvedoraApresentacao = new DesenvolvedoraApresentacao();
	public static DesenvolvedoraNegocios desenvolvedoraNegocios = new DesenvolvedoraNegocios();
	public static void main(String [] args) {
		
		
	    Cliente cliente = new Cliente();
	    Desenvolvedora desenvolvedora = new Desenvolvedora();
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
					break;
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


