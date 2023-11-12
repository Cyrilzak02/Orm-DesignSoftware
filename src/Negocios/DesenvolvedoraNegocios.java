package Negocios;

import java.io.IOException;

import Entidades.Desenvolvedora;
import Dados.DesenvolvedoraDados;

public class DesenvolvedoraNegocios {
	
	private DesenvolvedoraDados desenvolvedoraDados = new DesenvolvedoraDados();
public Boolean cadastrarDesenvolvedora(Desenvolvedora desenvolvedora) {
		
	    
		if (!this.desenvolvedoraDados.consultaCnpj(desenvolvedora).isEmpty()) {
			return false;
			
		}
		
		else {
		desenvolvedoraDados.cadastrar(desenvolvedora);
		return true;
		}
		
		
	}

public Desenvolvedora loginDesenvolvedora(String cnpj) {
	
    
	if (!this.desenvolvedoraDados.verificarDesenvolvedoraExistente(cnpj)) {
		return null;
		
	}
	
	else {
	
	return desenvolvedoraDados.fazerLoginDesenvolvedora(cnpj);
	}
	
	
}



}
