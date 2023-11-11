package Entidades;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Biblioteca {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "BIBLIO_ID")
	private long id;
	
	@OneToOne(fetch=FetchType.LAZY , mappedBy = "biblioteca")
	private Cliente cliente;
	
	
	@ManyToMany
	@JoinTable(
			name="Jogos_Biblioteca",
			joinColumns= {@JoinColumn(name="BIB_ID",referencedColumnName="BIBLIO_ID")},
			inverseJoinColumns= {@JoinColumn(name="JOGO_ID",referencedColumnName ="ID_JOGO")})
	private List<Jogo> Jogos;
	
	public Biblioteca () {}

}
