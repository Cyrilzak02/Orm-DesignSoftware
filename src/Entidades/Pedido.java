package Entidades;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_Pedido")
	private Long id;
	private Date dataPedido;
	private float precoTotal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLIENTE_ID")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="JOGO_ID")
	private Jogo jogo;
	
	public Pedido (Date dataPedido , float preco_total , Cliente cliente,Jogo jogo) {
		this.dataPedido = dataPedido;
		this.precoTotal = preco_total;
		this.cliente = cliente;
		this.jogo = jogo;
		
	}
	public Pedido() {}
	
	
	

	
	
	
	
	
	
	

}
