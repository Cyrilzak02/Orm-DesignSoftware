package Entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Desenvolvedora {
	
	@Id
	@Column(name="DES_ID")
	private float id;
	
    private String nome , cnpj , endereco;
    
    @OneToMany(mappedBy="desenvolvedora")
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
	
	

}
