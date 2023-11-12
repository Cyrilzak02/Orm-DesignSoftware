package Apresentacao;

import java.util.List;
import java.util.Scanner;

import javax.swing.ListCellRenderer;

import Dados.DesenvolvedoraDados;
import Entidades.Cliente;
import Entidades.Desenvolvedora;
import Negocios.ClienteNegocio;
import Negocios.DesenvolvedoraNegocios;
import Entidades.*;



public class Principal {
	public static ClienteApresentacao clienteApresentacao = new ClienteApresentacao();
	public static ClienteNegocio clienteNegocio = new ClienteNegocio();
	public static DesenvolvedoraApresentacao desenvolvedoraApresentacao = new DesenvolvedoraApresentacao();
	public static DesenvolvedoraNegocios desenvolvedoraNegocios = new DesenvolvedoraNegocios();
	public static JogoApresentacao jogoApresentacao = new JogoApresentacao();
	
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
			while(true) {
			System.out.println("=============Agora o que voce deseja fazer================");
			System.out.println("[1]- Publicar Jogo.");
			System.out.println("[2]- Visualizar Jogos Publicados.");
			System.out.println("[3]- Atualizar Versao Jogo");
			System.out.println("[4]- Remover Jogo");
			System.out.print("Resposta: ");
			String option = in.next();
			if(option.equals("1")) {
				Jogo jogo = jogoApresentacao.cadastrarJogo();
				Boolean publicou= desenvolvedoraNegocios.publicarJogo(desenvolvedora, jogo);
				if(!publicou) {
					System.out.println("Jogo ja esta cadastrado");
				}
				else {
					System.out.println("Jogo cadastrado com sucesso");
				}
				
			}
			if(option.equals("2")){
				List <Jogo> jogos_des = desenvolvedoraNegocios.listarJogos(desenvolvedora);
				if(jogos_des== null) {
					System.out.println("Voce nao publicou nenhum jogo ainda");
					continue;
				}
				for (int i=0;i<jogos_des.size();i++) {
					System.out.println(i+" - "+jogos_des.get(i).getNomeJogo());
				}
			}
			if(option.equals("3")) {
				List <Jogo> jogos_des = desenvolvedoraNegocios.listarJogos(desenvolvedora);
				if(jogos_des== null) {
					System.out.println("Voce nao publicou nenhum jogo ainda");
					continue;
				}
				for (int i=0;i<jogos_des.size();i++) {
					System.out.println(i+" - "+jogos_des.get(i).getNomeJogo());
				}
				
				boolean atualizaou = desenvolvedoraApresentacao.atualizar_Versao(desenvolvedora);
				
				if(!atualizaou) {
					System.out.println("A atualizacao da versao nao foi");
					continue;
				}
				System.out.println("A atualizacao foi feita com sucesso");
			}
			if(option.equals("4")) {
				
			}
			else {
				System.out.println("Okay. CIAO , CIAO.");
				break;
			}
			
			
			
		}
			
			
			
		}
			
		}
		
		
		}


