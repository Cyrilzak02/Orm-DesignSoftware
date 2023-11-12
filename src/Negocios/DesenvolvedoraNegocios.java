package Negocios;

import java.io.IOException;
import java.util.List;

import Entidades.Desenvolvedora;
import Dados.DesenvolvedoraDados;
import Entidades.Jogo;

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

public boolean publicarJogo(Desenvolvedora desenvolvedora , Jogo jogo) { // if the game has already been added, it will return false , else true
	if(desenvolvedoraDados.verificarJogos(desenvolvedora, jogo)) {
		return false;
	}
	
	desenvolvedoraDados.publicarJogo(desenvolvedora, jogo);
	return true;
	
	
}

public List listarJogos(Desenvolvedora desenvolvedora) {
	List<Jogo> jogos = desenvolvedoraDados.listarJogos(desenvolvedora);
	
	if(jogos.isEmpty()) {
		return null;
	}
	
	return jogos;
}
public boolean atualizarVersao(Desenvolvedora desenvolvedora , int index , float versao_nova) {
	List <Jogo> jogos = desenvolvedoraDados.listarJogos(desenvolvedora);
	if(index >= jogos.size()) {
		return false;
	}
	desenvolvedoraDados.atualizarVersao(jogos.get(index).getId(),versao_nova);
	return true;
	
	
	
}





}
