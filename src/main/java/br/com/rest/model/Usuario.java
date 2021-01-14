package br.com.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Usuario {

	@Id
	private String email;
	private String nome;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Aposta> apostas;
	
	public Usuario() {
        this.apostas = new ArrayList<Aposta>();
    }

    public Usuario(String email) {
        this.apostas = new ArrayList<Aposta>();
        this.email = email;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aposta> getApostas() {
		return apostas;
	}

	public void setApostas(List<Aposta> apostas) {
		this.apostas = apostas;
	}
    
	@Override
    public String toString() {
        return "Usuario [apostas=" + apostas + ", email=" + email + ", nome=" + nome + "]";
    }
}
