package Negocios;

import java.io.IOException;

import Entidades.Desenvolvedora;
import Dados.DesenvolvedoraDados;

public class DesenvolvedoraNegocios {
	
	private DesenvolvedoraDados desenvolvedoraDados;
public String cadastrarDesenvolvedora(Desenvolvedora desenvolvedora) {
		
	    
		if (!this.desenvolvedoraDados.consultaCnpj(desenvolvedora).isEmpty()) {
			return "Erro: A desenvolvedora ja foi cadastrada!";
			
		}
		
		else {
		desenvolvedoraDados.cadastrar(desenvolvedora);
		return "Desenvolvedora cadastrada com sucesso!";
		}
	}



}
