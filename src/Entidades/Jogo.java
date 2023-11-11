package Entidades;

import jakarta.persistence.*;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Jogo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_JOGO")
	private Long id;
	private String nomeJogo , tipoJogo;
	private float tamanhoJogo, preco , versao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DES_ID")
	private Desenvolvedora desenvolvedora;
	
	public Jogo(String nomeJogo , String tipoJogo, float tamanhoJogo, float preco , float versao,Desenvolvedora desenvolvedora) {
		this.nomeJogo = nomeJogo;
		this.tipoJogo = tipoJogo;
		this.tamanhoJogo = tamanhoJogo;
		this.preco = preco;
		this.versao = versao;
		this.desenvolvedora = desenvolvedora;
	}
	public Jogo() {}
	
	
	
	
	

}
