package Entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Desenvolvedora {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DES_ID")
	private long id;
	
    private String nome , cnpj , endereco;
    
    @OneToMany(mappedBy="desenvolvedora", cascade = CascadeType.PERSIST)
    private List<Jogo> jogos;
    
    
    
    public Desenvolvedora(String nome , String cnpj , String endereco) {
    	this.nome=nome;
    	this.cnpj = cnpj;
    	this.endereco=endereco;
    	this.jogos = new ArrayList<Jogo>();
    	}
    
    public Desenvolvedora() {}
    public String getNome(){
    	return this.nome;
    	
    }
   public String getCnpj() {
	   return this.cnpj;
   }
	
   public List getJogos() {
	   return this.jogos;
   }
   public void addListJogos(Jogo jogo) {
	   this.jogos.add(jogo);
   }
   
   public long getId() {
	   return this.id;
   }
	

}
