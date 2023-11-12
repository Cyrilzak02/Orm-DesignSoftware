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
	
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name="DES_ID")
	private Desenvolvedora desenvolvedora;
	
	public Jogo(String nomeJogo , String tipoJogo, float tamanhoJogo, float preco , float versao) {
		this.nomeJogo = nomeJogo;
		this.tipoJogo = tipoJogo;
		this.tamanhoJogo = tamanhoJogo;
		this.preco = preco;
		this.versao = versao;
		
	}
	public Jogo() {}
	
	public Desenvolvedora getDes() {
		return this.desenvolvedora;
	}
	public void setDes(Desenvolvedora desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}
	
	
	
	
	
	

}
